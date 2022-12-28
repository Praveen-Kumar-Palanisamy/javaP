package com.te.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.blog.com.te.entity.ViewerAddFavoritesPost;
import com.te.blog.dto.ViewerAddFavorites;


public interface viewerFavoitesPostrepository extends JpaRepository<ViewerAddFavoritesPost,Integer>{

	//boolean save(ViewerAddFavorites addFavorites);

}
