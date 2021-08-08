package com.dot.app.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dot.app.client.RajaOngkirClient;
import com.dot.app.exception.DataNotFoundException;
import com.dot.app.mapper.CityMapper;
import com.dot.app.model.City;
import com.dot.app.repo.CityRepo;

@Service
public class CityServiceImpl implements CityService{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	RajaOngkirClient rajaOngkirClient;

	@Autowired
	CityMapper cityMapper;
	
	@Override
	public List<City> getAllCity() {
		List<City> cityList = new ArrayList<>();
		cityList = cityRepo.findAll();
		if (!cityList.isEmpty()) {
			return cityList;
		}
		JSONObject cityObject = rajaOngkirClient.getCity(0);
		JSONArray cityArray = new JSONArray();
		cityArray = cityObject.getJSONObject("rajaongkir").getJSONArray("results");
		cityList = cityMapper.mapCityList(cityArray);
		cityRepo.saveAll(cityList);
		
		return cityList;
	}
	
	@Override
	public City getCity(int id) throws DataNotFoundException {
		City city = cityRepo.findCityByCityId(id);
		if (city != null) {
			return city;
		}
		
		JSONObject cityObject = rajaOngkirClient.getCity(0);
		JSONArray cityArray = new JSONArray();
		cityArray = cityObject.getJSONObject("rajaongkir").getJSONArray("results");
		List<City> cityList = new ArrayList<>();
		cityList = cityMapper.mapCityList(cityArray);
		cityRepo.saveAll(cityList);
		
		city = cityRepo.findCityByCityId(id);
		if (city == null) {
			LOGGER.error("City with id " + id + " not found");
			throw new DataNotFoundException("City with id " + id + " not found");
		}
		return city;
	}
}
