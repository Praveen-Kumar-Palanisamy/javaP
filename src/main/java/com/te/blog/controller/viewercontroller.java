
package com.te.blog.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.blog.com.te.entity.PostComment;
import com.te.blog.com.te.entity.Posts;
import com.te.blog.com.te.entity.Tags;
import com.te.blog.com.te.entity.User;
import com.te.blog.dto.DeletViewerCommentDto;
import com.te.blog.dto.SearchByname;
import com.te.blog.dto.ViewerAddFavorites;
import com.te.blog.dto.ViewerCommentDto;
import com.te.blog.dto.viewerSearchCategoryDto;
import com.te.blog.response.AppResponse;
import com.te.blog.services.ViewerServiers;
@RequestMapping("/Viewer")
@RestController
public class viewercontroller {
	@Autowired
	private ViewerServiers viewerServiers;
	@Autowired
	private AppResponse response;
	@RequestMapping("/viewercomment")
	public ResponseEntity<AppResponse> viewercomment(@RequestBody ViewerCommentDto commentDto){
		PostComment viewercomment = viewerServiers.viewercomment(commentDto);
		if (viewercomment !=null) {
			response.setError(false);
			response.setMessage("Add to Favorite successfully");
			response.setData(viewercomment);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("Not Add to Favorite");
			response.setData(viewercomment);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);	
	}
	
	}	
	@RequestMapping("/deletcomment")
	public ResponseEntity<AppResponse> delComment(@RequestBody DeletViewerCommentDto commentDto ){
		boolean deletComment = viewerServiers.deletComments(commentDto);
		if (deletComment==true) {
			response.setError(false);
			response.setMessage("Add to Favorite successfully");
			response.setData(deletComment);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("Not Add to Favorite");
			response.setData(deletComment);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);	
	}	
	}
	@PostMapping("/viewerpostlist")
	public ResponseEntity<AppResponse> ViewerpostList(){
		List<Posts> viewerpostList = viewerServiers.ViewerpostList();
		if (viewerpostList!=null) {
			response.setError(false);
			response.setMessage("postList successfully");
			response.setData(viewerpostList);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("no post is here");
			response.setData(viewerpostList);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);	
	}
		
	}
	
	@PostMapping("/postcategory")
	public ResponseEntity<AppResponse> postListCategory(@RequestBody viewerSearchCategoryDto categoryDto){
		List<Posts> postList = viewerServiers.postList(categoryDto);
		if (postList!=null) {
			response.setError(false);
			response.setMessage("Add to Favorite successfully");
			response.setData(postList);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("Not Add to Favorite");
			response.setData(postList);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);	
	}		
	}
	

	@PostMapping("/addtofavorite")
	public  ResponseEntity<AppResponse> ViewerFavorite(@RequestBody ViewerAddFavorites  addFavorites){
		boolean viewerAddFavorites = viewerServiers.ViewerAddFavorites(addFavorites);
		if (viewerAddFavorites==true) {
			response.setError(false);
			response.setMessage("Add to Favorite successfully");
			response.setData(viewerAddFavorites);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("Not Add to Favorite");
			response.setData(viewerAddFavorites);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);	
	}		
	}
	
	@PostMapping("/favorites")
	public  ResponseEntity<AppResponse> ViewerDeletFavorite(@RequestBody ViewerAddFavorites  addFavorites){
		boolean viewerAddFavorites = viewerServiers.ViewerDeleteFavorites(addFavorites);
		if (viewerAddFavorites==true) {
			response.setError(false);
			response.setMessage("Add to Favorite successfully");
			response.setData(viewerAddFavorites);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("Not Add to Favorite");
			response.setData(viewerAddFavorites);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);	
	}	
	
	}
	
	
	@PostMapping("/SearchByName")
	public ResponseEntity<AppResponse> searchByname(@RequestBody SearchByname byname ){
		List<Posts> searchByName = viewerServiers.searchByName(byname);
		if (searchByName!=null) {
			response.setError(false);
			response.setMessage("Add to Favorite successfully");
			response.setData(searchByName);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
		} else {
			response.setError(false);
			response.setMessage("Not Add to Favorite");
			response.setData(searchByName);
			response.setStatus(200);
			return new ResponseEntity<AppResponse>(response, HttpStatus.OK);	
	}		
		
	}
	
//	@PostMapping("/sharetag/{id}")
//	public ResponseEntity<String> shareTag(@PathVariable Integer id) {
//	  	Optional<Tags> body=viewerServiers.shareTag(id);
//		String body="viewer shared ";
//		return ResponseEntity.ok(body);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
