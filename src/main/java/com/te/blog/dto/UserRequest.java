package com.te.blog.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserRequest {
	
	private String fristName;
	private String password;

}
