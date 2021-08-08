package com.dot.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dot.app.model.City;

public interface CityRepo extends JpaRepository<City, Integer> {
	public City findCityByCityId(int id);

}
