package com.te.blog.services;

import java.util.List;

import com.te.blog.com.te.entity.PostComment;
import com.te.blog.com.te.entity.Posts;
import com.te.blog.com.te.entity.User;
import com.te.blog.dto.DeletCommentDto;
import com.te.blog.dto.FavoritesPostDto;
import com.te.blog.dto.PostCommentDto;
import com.te.blog.dto.RegisterPostsDto;
import com.te.blog.dto.RegisterUserDto;
import com.te.blog.dto.SearchByCategory;

public interface Serviesinterface {
	public boolean UserRegister(RegisterUserDto dto);
	User UserUpdate(RegisterUserDto dto);
	Long postRegister(RegisterPostsDto postsDto) ;
	List<Posts> postList() ;
	PostComment commentUser(PostCommentDto commentDto);
	PostComment commentUserUpdate(PostCommentDto commentDto);
	 boolean addFavorier(FavoritesPostDto favoritesPostDto);
	 List<Posts> seachByCategory(SearchByCategory byCategory);
	 Long DeletPost(RegisterPostsDto dto);
	 boolean deletComment(DeletCommentDto commentDto);
}
