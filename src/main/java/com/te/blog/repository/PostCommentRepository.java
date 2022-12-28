package com.te.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.blog.com.te.entity.PostComment;

public interface PostCommentRepository extends JpaRepository<PostComment, Integer> {

}
