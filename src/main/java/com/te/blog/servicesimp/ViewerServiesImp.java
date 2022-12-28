package com.te.blog.servicesimp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.blog.blogexeception.BlogException;
import com.te.blog.com.te.entity.PostComment;
import com.te.blog.com.te.entity.Posts;
import com.te.blog.com.te.entity.Tags;
import com.te.blog.com.te.entity.User;
import com.te.blog.com.te.entity.ViewerAddFavoritesPost;
import com.te.blog.dto.DeletViewerCommentDto;
import com.te.blog.dto.SearchByname;
import com.te.blog.dto.TagDto;
import com.te.blog.dto.ViewerCommentDto;
import com.te.blog.dto.viewerSearchCategoryDto;
import com.te.blog.repository.PostsRepository;
import com.te.blog.repository.TagRepository;
import com.te.blog.repository.UserRepository;
import com.te.blog.repository.ViewerComment;
import com.te.blog.repository.viewerFavoitesPostrepository;
import com.te.blog.services.ViewerServiers;
import com.te.blog.dto.ViewerAddFavorites;
@Service
public class ViewerServiesImp implements ViewerServiers {
	@Autowired
	private ViewerComment comment;
	@Autowired
	private PostsRepository postsRepository;
	@Autowired
	private TagRepository repository;
	@Autowired
	private viewerFavoitesPostrepository favoitesPostrepository;
	@Autowired
	private UserRepository userRepository;
	

	public PostComment viewercomment(ViewerCommentDto commentDto) {
		PostComment commentInfo = new PostComment();
		BeanUtils.copyProperties(commentDto, commentInfo);
		if (commentInfo != null) {
			return comment.save(commentInfo);
		}
		throw new BlogException("data not found");
	}

	public boolean deletComments(DeletViewerCommentDto commentDto) {
		PostComment postComment = comment.findById(commentDto.getId()).orElse(null);
		if (postComment != null) {
			comment.deleteById(postComment.getId());
			return true;
		}
		throw new BlogException("data not found");
	}

	@Override
	public List<Posts> postList(viewerSearchCategoryDto categoryDto) {
		List<Posts> posts2 = postsRepository.findAll();
		return posts2.stream().filter((i) -> i.getTitle() == categoryDto.getTitle()).collect(Collectors.toList());

	}

	@Override
	public List<Posts> ViewerpostList() {
		List<Posts> postList = postsRepository.findAll();
		return postList;

	}

	

	@Override
	public boolean ViewerAddFavorites(ViewerAddFavorites addFavorites) {
		if (addFavorites != null) {
			ViewerAddFavoritesPost addFavorites2 = new ViewerAddFavoritesPost();
			BeanUtils.copyProperties(addFavorites, addFavorites2);
			favoitesPostrepository.save(addFavorites2);
			return true;
		}
		throw new BlogException("data not save");

	}

	public boolean ViewerDeleteFavorites(ViewerAddFavorites addFavorites) {
		ViewerAddFavorites addFavorites2 = new ViewerAddFavorites();
		BeanUtils.copyProperties(addFavorites, addFavorites2);
		if (addFavorites2 != null) {
			favoitesPostrepository.deleteById(addFavorites2.getId());
			return true;
		}
		throw new BlogException("data not delet");

	}

	
	public List<Posts> searchByName(SearchByname byname) {
		List<Posts> findAll = postsRepository.findAll();
		return findAll.stream().filter((i) -> i.getUser().getFisrtName() == byname.getFisrtName()).collect(Collectors.toList());
	}

	@Override
	public void TagPost(TagDto dto) {
		// TODO Auto-generated method stub
		
	}


//	public Optional<Tags> shareTag(Integer id) {
//			Optional<Tags> findById = repository.findById(id);
//			if(findById!=null) {
//			return findById;
//		}
//			throw new BlogException("enter correct tad id");
//		}


//	@Override
//	public Tags shareTag(Long id) {
//		Tags tags = tagRepository.findById(id).orElse(null);
//		if(tags!=null) {
//		return tags;
//	}
//		throw new BlogException("enter correct tad id");
//	}





		
	

//	public Boolean search(DeleteDto search) {
//		EmployeePrimary employeePrimaryInfo = emprepositoryinterface.findById(search.getEmployeeId()).orElse(null);
//		if (employeePrimaryInfo != null) {
//			emprepositoryinterface.deleteById(employeePrimaryInfo.getEmployeeId());
//			return true;
//		}
//		// return false;
//		throw new Exceptionclass("data not found");
//	}

}
