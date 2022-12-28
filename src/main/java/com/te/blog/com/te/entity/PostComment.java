package com.te.blog.com.te.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;
@Entity
@Component
@Data
public class PostComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@Column(nullable = false)
	private String title;
	private Integer published;
	private Date  createdAt;
	private Date publishedAt;
	//@Column(nullable = false)
	private String content;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="parentid")
	private PostComment comments;
	
	//@JsonIgnoreProperties({"categoryList", "tagsList","postMetaList","users"})
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="postid")
	private Posts posts;
	
	

}
