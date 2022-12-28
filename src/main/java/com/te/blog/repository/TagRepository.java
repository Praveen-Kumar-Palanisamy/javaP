package com.te.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blog.com.te.entity.Tags;
@Repository
public interface TagRepository extends JpaRepository<Tags, Integer>{

}
