package com.te.blog.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.te.blog.com.te.entity.Posts;

@Component
public class postsListDto {
	private Integer id;
	private List<Posts> posts;

}
