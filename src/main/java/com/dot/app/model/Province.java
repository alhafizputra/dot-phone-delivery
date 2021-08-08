package com.dot.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Province {
	
	@Id
	private int provinceId;
	private String province;
	
	public Province() {
	}
	
	public Province(int provinceId, String province) {
		super();
		this.provinceId = provinceId;
		this.province = province;
	}
	
	public int getProvinceId() {
		return provinceId;
	}
	public void setProvince_id(int provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
}
