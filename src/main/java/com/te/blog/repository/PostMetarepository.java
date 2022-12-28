package com.te.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.blog.com.te.entity.PostMeta;
@Repository
public interface PostMetarepository extends JpaRepository<PostMeta, Integer> {

}
