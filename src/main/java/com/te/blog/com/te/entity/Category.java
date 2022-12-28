package com.te.blog.com.te.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import lombok.Data;

@Entity
@Data
@Component
public class Category {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String metaTitle;
	private String slug;
	//@Column(nullable = false)
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMetaTitle() {
		return metaTitle;
	}
	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="parentid")
	private List<Category> categoryList=Lists.newArrayList();
	
//
//	@ManyToMany
//	@JoinTable(name="post_category",joinColumns = @JoinColumn(name="postId",referencedColumnName = "id"),
//				inverseJoinColumns = @JoinColumn(name="categoryId",referencedColumnName = "id"))
//	private List<Posts> posts;


}
