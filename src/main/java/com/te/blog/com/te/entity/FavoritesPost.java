package com.te.blog.com.te.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NonNull;
@Entity
@Component
@Data
public class FavoritesPost {
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="favid")
	List<Posts> list=new ArrayList<>();
	
	
}
