package com.te.blog.com.te.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Component
public class PostMeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postMetaId;
	//@Column(nullable = false)
	private String key;
	//@Column(nullable = false)
	private String content;
	
	public Integer getPostMetaId() {
		return postMetaId;
	}
	public void setPostMetaId(Integer postMetaId) {
		this.postMetaId = postMetaId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonIgnoreProperties({"categoryList", "tagsList","comments"})
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "post_id", referencedColumnName = "id", nullable = true)
	private Posts posts;
	

}
