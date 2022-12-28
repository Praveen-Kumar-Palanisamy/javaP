package com.te.blog.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SearchByname {
	private String fisrtName;

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

}
