package com.te.blog.services;

import java.util.List;
import java.util.Optional;

import com.te.blog.com.te.entity.PostComment;
import com.te.blog.com.te.entity.Posts;
import com.te.blog.com.te.entity.Tags;
import com.te.blog.com.te.entity.User;
import com.te.blog.dto.DeletViewerCommentDto;
import com.te.blog.dto.SearchByname;
import com.te.blog.dto.TagDto;
import com.te.blog.dto.ViewerAddFavorites;
import com.te.blog.dto.ViewerCommentDto;
import com.te.blog.dto.viewerSearchCategoryDto;

public interface ViewerServiers {
	
	PostComment viewercomment(ViewerCommentDto commentDto);
    boolean deletComments(DeletViewerCommentDto commentDto);
    List<Posts> postList(viewerSearchCategoryDto categoryDto);
    List<Posts> ViewerpostList();
	void TagPost(TagDto dto);

	boolean ViewerAddFavorites(com.te.blog.dto.ViewerAddFavorites addFavorites);
	
	boolean ViewerDeleteFavorites(com.te.blog.dto.ViewerAddFavorites addFavorites);
	List<Posts> searchByName(SearchByname byname);
//	Optional<Tags> shareTag(Long id);
}
