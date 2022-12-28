package com.te.blog.com.te.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
@Entity
@Component
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String fisrtName;
	@Column(nullable = false)
	private String middleName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String mobile;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date registeredAt;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date lastLogin;
	@Column(nullable = false)
	private String intro;
	@Column(nullable = false)
	private String profile;
	
//	@OneToMany(targetEntity = Posts.class,cascade = CascadeType.ALL)
//	@JoinColumn(name="authorId",referencedColumnName = "id")
//	private List<Posts> posts;
//	
	
//	@OneToMany(targetEntity =Posts.class,cascade = CascadeType.ALL )
//	@JoinColumn(name="authorId",referencedColumnName ="id")
//	private List<Posts> posts;
	
}
