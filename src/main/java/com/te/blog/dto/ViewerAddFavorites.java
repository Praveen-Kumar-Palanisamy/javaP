package com.te.blog.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.te.blog.com.te.entity.Posts;

import lombok.Data;
@Component
@Data
public class ViewerAddFavorites {
	private Integer id;
	List<Posts> list=new ArrayList<>();
}
