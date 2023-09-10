package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String emodel;
	private String epower;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_e_id")
	private Car car;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmodel() {
		return emodel;
	}

	public void setEmodel(String emodel) {
		this.emodel = emodel;
	}

	public String getEpower() {
		return epower;
	}

	public void setEpower(String epower) {
		this.epower = epower;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Engine [eid=" + eid + ", emodel=" + emodel + ", epower=" + epower + "]";
	}
	
	
}
