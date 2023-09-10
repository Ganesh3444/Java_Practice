package com.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fname;
	
	@Lob
	private byte[] fdata;
	
	private String fileDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	public String getFileDate() {
		return fileDate;
	}

	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}

	@Override
	public String toString() {
		return "FileData [id=" + id + ", fname=" + fname + ", fdata=" + Arrays.toString(fdata) + ", fileDate="
				+ fileDate + "]";
	}
	
	
	
}
