package com.dot.app.service;

import java.util.List;

import com.dot.app.exception.DataNotFoundException;
import com.dot.app.model.City;

public interface CityService {
	List<City> getAllCity();
	City getCity(int id) throws DataNotFoundException;
}
