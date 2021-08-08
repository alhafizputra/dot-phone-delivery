package com.dot.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

	public Product() {

	}
	
	public Product(int id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
	@Id
	private int id;

	private String name;
	private String code;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
