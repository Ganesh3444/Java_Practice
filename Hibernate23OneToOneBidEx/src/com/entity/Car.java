package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private String cmodel;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "car")
	
	private Engine engine;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmodel() {
		return cmodel;
	}

	public void setCmodel(String cmodel) {
		this.cmodel = cmodel;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cname=" + cname + ", cmodel=" + cmodel + ", engine=" + engine + "]";
	}
	
	
}
