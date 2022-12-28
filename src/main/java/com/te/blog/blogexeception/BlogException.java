package com.te.blog.blogexeception;

public class BlogException extends RuntimeException {
	private String msg;
	
	public BlogException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
		
	}
	


}
