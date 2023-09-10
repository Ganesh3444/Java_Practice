package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "t_s_id")
	private List<Student> slist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", slist=" + slist + "]";
	}
	
	
}
