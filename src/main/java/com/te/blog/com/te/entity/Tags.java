package com.te.blog.com.te.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Data
@Component
public class Tags {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String metaTitle;
	public String getMetaTitle() {
		return metaTitle;
	}
	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}
	private String slug;
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
	
//	@JsonIgnoreProperties({"categoryList","postMetaList","comments"})
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinTable(name = "post_tag")
//	private Posts posts;
//	
//	@ManyToMany
//	@JoinTable(name="post_tag",joinColumns = @JoinColumn(name="postid",referencedColumnName = "id"),
//				inverseJoinColumns = @JoinColumn(name="tagid",referencedColumnName = "id"))
//	private List<Posts> posts;
}
