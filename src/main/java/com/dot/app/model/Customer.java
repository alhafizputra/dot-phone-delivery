package com.dot.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	public Customer() {

	}
	
	public Customer(int id, String name, String phoneNo, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	@Id
	private int id;

	private String name;
	private String phoneNo;
	private String address;
	
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
