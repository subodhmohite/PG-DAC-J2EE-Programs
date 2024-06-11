package com.blogs.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag extends BaseEntity {
	@Column(length = 10, unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	  @Override public boolean equals(Object o) {
	  System.out.println("in tags equals");
	  if(o instanceof Tag) { Tag tag =(Tag)o;
	  return this.name.equals(tag.name); 
	  }
	  return false; }
	  
	  @Override public int hashCode()
	  { 
		 System.out.println("in tags hashCode");
	  return this.hashCode();
	  }
	  
	 
	@Override
	public String toString() {
		return "Tag [name=" + name + "]";
	}

	
}
