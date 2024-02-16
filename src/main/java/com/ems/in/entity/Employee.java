package com.ems.in.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id // for specifying the property as primary key column in the table
	private int eid;
	@Column(unique = true) // for specifying the property as non-primary key column in the table
	private String email;
	@Column(nullable = false) // for specifying the property as non-primary key column in the table
	private String ename;
	@Column(nullable = false) // for specifying the property as non-primary key column in the table
	private String ecity;

	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

}
