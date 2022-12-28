package com.te.blog.servicesimp;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.te.blog.blogexeception.BlogException;
import com.te.blog.com.te.entity.Category;
import com.te.blog.com.te.entity.FavoritesPost;
import com.te.blog.com.te.entity.PostComment;
import com.te.blog.com.te.entity.PostMeta;
import com.te.blog.com.te.entity.Posts;
import com.te.blog.com.te.entity.Tags;
import com.te.blog.com.te.entity.User;
import com.te.blog.dto.DeletCommentDto;
import com.te.blog.dto.DeletFavoritesDto;
import com.te.blog.dto.FavoritesPostDto;
import com.te.blog.dto.PostByDateDto;
import com.te.blog.dto.PostCommentDto;
import com.te.blog.dto.RegisterPostsDto;
import com.te.blog.dto.RegisterUserDto;
import com.te.blog.dto.SearchByCategory;
import com.te.blog.dto.UserRequest;
import com.te.blog.repository.AddFavoritesRepository;
import com.te.blog.repository.CategoryRepository;
import com.te.blog.repository.PostCommentRepository;
import com.te.blog.repository.PostMetarepository;
import com.te.blog.repository.PostsRepository;
import com.te.blog.repository.TagRepository;
//import com.te.blog.repository.PostsRepository;
import com.te.blog.repository.UserRepository;
import com.te.blog.services.Serviesinterface;




@Service
public class ServicesImp implements Serviesinterface,UserDetailsService{
	@Autowired
	private UserRepository repository;
	@Autowired
	private PostsRepository postsRepository;
	@Autowired
    private User users;
	@Autowired
	private Tags tags;
	@Autowired
	private Category category;
	@Autowired
	private PostMeta meta;
	@Autowired
	private Posts posts;
	@Autowired
	private PostCommentRepository commentRepository;
	@Autowired
    private AddFavoritesRepository addFavoritesRepository;
	@Autowired
    private TagRepository repository2;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
    private PostMetarepository metarepository;
	
	@Override
	public boolean UserRegister(RegisterUserDto dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		repository.save(user);
		return true;
	}

	@Override
	public User UserUpdate(RegisterUserDto dto) {
		User user=repository.findById(dto.getId()).orElse(null);
		if(user!=null) {
			BeanUtils.copyProperties(dto, user);
			return  repository.save(user);	
		}
		return null;
	}

	
	public Long postRegister(RegisterPostsDto postsDto) {
		BeanUtils.copyProperties(postsDto, posts);
		category.setMetaTitle(posts.getMetaTitle());
		category.setSlug(posts.getSlug());
		category.setTitle(posts.getTitle());
		category.setContent(posts.getContent());
		categoryRepository.save(category);
		tags.setTitle(posts.getMetaTitle());
		tags.setMetaTitle(posts.getMetaTitle());
		tags.setSlug(posts.getSlug());
		repository2.save(tags);
		meta.setContent(posts.getContent());
		metarepository.save(meta);
		postsRepository.save(posts);
		List<Posts> findAll = postsRepository.findAll();
		 long count = findAll.stream().count();
		posts.setCount(count);
		postsRepository.save(posts);
		return count;
	}

	public List<Posts> postList() {
		List<Posts> findAll = postsRepository.findAll();
		return findAll;
	}

	public List<Posts> postByDate(PostByDateDto byDateDto) {
		List<Posts> posts2 = postsRepository.findAll();
		return posts2.stream().filter((i) -> i.getPublishedAt() == byDateDto.getDate()).collect(Collectors.toList());
	}
    public  List<Posts> seachByCategory(SearchByCategory byCategory) {
    	List<Posts> posts = postsRepository.findAll();
    	 List<Posts> posts2 = posts.stream().filter((i) -> i.getTitle() == byCategory.getTitle()).collect(Collectors.toList());
    	 return posts2;
		
	}


	public PostComment commentUser(PostCommentDto commentDto) {
		PostComment comment=new PostComment();
		comment.setPosts(posts);
		BeanUtils.copyProperties(commentDto, comment);
		if(comment!=null) {
		commentRepository.save(comment);
		return comment;	
		}		
		throw new BlogException("data not found");

		
	}


	public PostComment commentUserUpdate(PostCommentDto commentDto) {
		PostComment comment=new PostComment();
		BeanUtils.copyProperties(commentDto, comment);
		commentRepository.save(comment);
		return comment;

	}

	public boolean addFavorier(FavoritesPostDto favoritesPostDto) {
		FavoritesPost favoritesPost=new FavoritesPost();
		BeanUtils.copyProperties(favoritesPostDto, favoritesPost);
		
		if(favoritesPost!=null) {
			addFavoritesRepository.save(favoritesPost);
		return true;
		}
		throw new BlogException("data not found");

		
	}

	public Long DeletPost(RegisterPostsDto dto) {
	Posts delet = postsRepository.findById(dto.getId()).orElse(null);
		if(delet!=null) {
			postsRepository.deleteById(delet.getId());
			List<Posts> findAll = postsRepository.findAll();
			Long count = findAll.stream().count();
			posts.setCount(count);
			postsRepository.save(posts);
			return count;	
		}
		throw new BlogException("data not found");
	}

	public boolean deletComment(DeletCommentDto commentDto) {
		PostComment delet = commentRepository.findById(commentDto.getId()).orElse(null);
		if(delet!=null) {
			commentRepository.deleteById(delet.getId());
			return true;
		}
		throw new BlogException("data not found");
	}

	public boolean deletFavorites(DeletFavoritesDto favoritesPostDto) {
		FavoritesPost favoritesPost=new FavoritesPost();
		BeanUtils.copyProperties(favoritesPostDto, favoritesPost);
		
		if(favoritesPost!=null) {
			addFavoritesRepository.deleteById(favoritesPost.getId());
		return true;
	}throw new BlogException("No Favorites post");
	
	
	
	}

	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User findByFisrtName = repository.findByFisrtName(fisrtName);
//		if (findByFisrtName == null) {
//			throw new UsernameNotFoundException("user" + fisrtName + "not exist");
//		}
//		if (findByFisrtName.getRole() == null || findByFisrtName.getRole().isEmpty()) {
//			throw new UsernameNotFoundException("user has no roles");
//		}
//		Collection<GrantedAuthority> authorities = findByFisrtName.getRole().stream()
//				.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
//
//		return new User(findByFisrtName.getFisrtName(), findByFisrtName.getPassword(), authorities);
//		
//	}
//
//	public String Login(UserRequest request) {
//		User users = repository.findByFisrtName(request.getUserName());
//		 Set<String> role = users.getRole();
//
//		if (request.getUserName().equals(users.getFisrtName()) && request.getPassword().equals(users.getPassword())) {
//			if(role.contains(request.getRole())) {
//			return users.getFisrtName() + "login sucessful!!!";
//			}
//
//		}
//		throw new BlogException("some one not match");
//		return null;
//	}
//	
//	}
