package com.te.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.te.blog.com.te.entity.PostComment;
import com.te.blog.com.te.entity.Posts;
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
import com.te.blog.response.AppResponse;
import com.te.blog.servicesimp.ServicesImp;

@RestController
@RequestMapping("/user")
public class BlogController {
	@Autowired
	private ServicesImp servicesImp;
	@Autowired
	private AppResponse appResponse;

	@PostMapping("/userRegister")
	public ResponseEntity<String> Users(@RequestBody RegisterUserDto dto) {
		boolean userRegister = servicesImp.UserRegister(dto);
		String body="post is Add"+userRegister;
		return ResponseEntity.ok(body);
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody UserRequest request) {
		String token = servicesImp.Login(request);
		return ResponseEntity.ok().body("logged in successful!!!");
	}
	
	
//	@PostMapping("/addpost")
//	public ResponseEntity<String> getRegister(@RequestBody PostDto posts) {
//		Long id = userService.register(posts);
//		String body = "post  " + id + " is added";
//		return ResponseEntity.ok(body);
//	}

	@PostMapping("/userupdate")
	public ResponseEntity<AppResponse> UserUpdate(@RequestBody RegisterUserDto dto) {
		User user = servicesImp.UserUpdate(dto);// note
		if (user != null) {
			appResponse.setError(false);
			appResponse.setMessage("register successfully");
			appResponse.setData(user);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("register unsuccessfully");
			appResponse.setData(user);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		}

	}
	

	@PostMapping("/postregister")
	public ResponseEntity<String> post(@RequestBody RegisterPostsDto postsDto) {
		 Long postRegister = servicesImp.postRegister(postsDto);
		String body="post is Add total number"+postRegister;
		return ResponseEntity.ok(body);
	
	}
	@PostMapping("/Deletpost")
	public ResponseEntity<String> DeletPost(@RequestBody RegisterPostsDto dto){
            Long deletPost = servicesImp.DeletPost(dto);
            String body="post is remove total number "+deletPost;
            return ResponseEntity.ok(body);
        	
	}
	

	@PostMapping("/postlist")
	public ResponseEntity<AppResponse> posList() {
		List<Posts> postslist = servicesImp.postList();
		if (postslist != null) {
			appResponse.setError(false);
			appResponse.setMessage("register successfully");
			appResponse.setData(postslist);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("register unsuccessfully");
			appResponse.setData(postslist);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}
	}

	@PostMapping("/searchpostbydate")
	public ResponseEntity<AppResponse> postByDate(@RequestBody PostByDateDto byDateDto) {
		List<Posts> post = servicesImp.postByDate(byDateDto);
		if (post != null) {
			appResponse.setError(false);
			appResponse.setMessage("This is you list of post");
			appResponse.setData(post);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("No list ");
			appResponse.setData(post);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}
	}
	@PostMapping("/searchbycategory")
	public ResponseEntity<AppResponse> posByCategory(@RequestBody SearchByCategory byCategory){
		List<Posts> seachByCategory = servicesImp.seachByCategory(byCategory);
		if (seachByCategory!=null) {
			appResponse.setError(false);
			appResponse.setMessage("This is you list of post");
			appResponse.setData(seachByCategory);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("No list ");
			appResponse.setData(seachByCategory);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}
		
	}

	@PostMapping("/commentuser")
	public ResponseEntity<AppResponse> usercomment(@RequestBody PostCommentDto commentDto) {
		PostComment commentUser = servicesImp.commentUser(commentDto);
		if (commentUser != null) {
			appResponse.setError(false);
			appResponse.setMessage("This is you list of post");
			appResponse.setData(commentUser);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("No list ");
			appResponse.setData(commentUser);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}
	}

	@PostMapping("/commentuserupdate")
	public ResponseEntity<AppResponse> commentUserUpdate(@RequestBody PostCommentDto commentDto) {
		PostComment commentUser = servicesImp.commentUserUpdate(commentDto);
		if (commentUser != null) {
			appResponse.setError(false);
			appResponse.setMessage("This is you list of post");
			appResponse.setData(commentUser);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("No list ");
			appResponse.setData(commentUser);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}
	}
	@RequestMapping("/deletcomment")
	public ResponseEntity<AppResponse> deletComment(@RequestBody DeletCommentDto commentDto){
		boolean deletComment = servicesImp.deletComment(commentDto);
		if (deletComment ==true) {
			appResponse.setError(false);
			appResponse.setMessage("This is you list of post");
			appResponse.setData(deletComment);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("No list ");
			appResponse.setData(deletComment);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}
	}
	
	
    @PostMapping("/favorites")
	public ResponseEntity<AppResponse> addFavorier(@RequestBody FavoritesPostDto favoritesPostDto) {
		boolean addFavorier = servicesImp.addFavorier(favoritesPostDto);
		if (addFavorier == true) {
			appResponse.setError(false);
			appResponse.setMessage("Add to Favorite successfully");
			appResponse.setData(addFavorier);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("Not Add to Favorite");
			appResponse.setData(addFavorier);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}

	}
    

    @PostMapping("/removefavorites")
	public ResponseEntity<AppResponse> deletFavorites(@RequestBody DeletFavoritesDto favoritesPostDto) {
		boolean addFavorier = servicesImp.deletFavorites(favoritesPostDto);
		if (addFavorier == true) {
			appResponse.setError(false);
			appResponse.setMessage("delet Favorite post successfully");
			appResponse.setData(addFavorier);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
		} else {
			appResponse.setError(false);
			appResponse.setMessage("delet Favorite post Favorite");
			appResponse.setData(addFavorier);
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);

		}

	}

}
