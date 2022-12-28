package com.te.blog.dto;

import org.springframework.stereotype.Component;

@Component
public class PostMetaDto {

	private String key;
	private String content;
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
	
}
