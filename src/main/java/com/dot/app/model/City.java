package com.dot.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class City {

	@Id
	private int cityId;
	private String cityName;
	private int provinceId;
	private String province;
	private String type;
	private String postalCode;
	
	public City() {
		
	}
	
	public City(Integer cityId, String cityName, Integer provinceId, String province, String type,
			String postalCode) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.provinceId = provinceId;
		this.province = province;
		this.type = type;
		this.postalCode = postalCode;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCity_name(String cityName) {
		this.cityName = cityName;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvince_id(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostal_code(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
}
