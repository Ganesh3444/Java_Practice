package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mobno;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AdharDetails adharDetails;

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

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public AdharDetails getAdharDetails() {
		return adharDetails;
	}

	public void setAdharDetails(AdharDetails adharDetails) {
		this.adharDetails = adharDetails;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobno=" + mobno + ", adharDetails=" + adharDetails + "]";
	}
	
	
	
}
