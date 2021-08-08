package com.dot.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int origin;
	private int destination;
	private int weight;
	private String courier;
	
	@Column(length = 4000)
	private String results;
	public Cost() {
	}
	
	public Cost(int origin, int destination, int weight, String courier, String results) {
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
		this.courier = courier;
		this.results = results;
	}

	public int getId() {
		return id;
	}
	public int getOrigin() {
		return origin;
	}
	public void setOrigin(int origin) {
		this.origin = origin;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
}
