package com.janwinsoft.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="User")
public class User {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
	   
  @Column(name="first_name")
  private String firstName;
	  
  @Column(name="last_name")
  private String lastName;
  
  @Column(name="course")
  private String course;
  
  @Column(name="is_active")
  private Boolean active;
	 
	 

}
