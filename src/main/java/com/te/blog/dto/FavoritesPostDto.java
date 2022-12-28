package com.te.blog.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.te.blog.com.te.entity.Posts;

import lombok.NonNull;
@Component
public class FavoritesPostDto {
	List<Posts> list=new ArrayList<>();

}
