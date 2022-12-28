package com.te.blog.dto;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class PostByDateDto {
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private Date date;

	

}
