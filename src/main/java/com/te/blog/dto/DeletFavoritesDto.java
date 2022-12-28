package com.te.blog.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class DeletFavoritesDto {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
