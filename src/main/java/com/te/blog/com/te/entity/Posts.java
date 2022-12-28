package com.te.blog.com.te.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Component
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//@Column(nullable = false)
	private String title;
	//@Column(nullable = false)
	private String metaTitle;
	//@Column(nullable = false)
	private String slug;
	//@Column(nullable = false)
	private String summary;
	//@Column(nullable = false)
//	@JsonFormat(pattern = "yyyy-mm-dd")
	//private String published;
	//@Column(nullable = false)
//	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date createdAt;
//	@Column(nullable = false)
//	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updatedAt;
//	@Column(nullable = false)
//	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date publishedAt;
//	@Column(nullable = false)
	private String content;
	
	private  long count;
	
	
	
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "parentId", referencedColumnName = "Id")
//	private List<Posts> posts;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "postid", referencedColumnName = "Id")
//	private List<PostComment> postComments;

	

	@ManyToMany
	private List<Tags> tags;

	@ManyToMany
	private List<Category> categeries;
	
	@ManyToOne
	@JoinColumn(name ="authorid")
	private User user;
	
//	@JsonIgnoreProperties({"categoryList","tagsList","postMetaList","users"})
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="parentid")
//	private List<Posts> parentPosts;
//	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "posts")
	// @JoinColumn(name="postid")
	private List<PostMeta> postMetaList = Lists.newArrayList();

//@OneToMany(cascade = CascadeType.ALL)
//@JoinColumn(name = "postId", referencedColumnName = "id")
//private List<PostMeta> postMetas;
//	
}
