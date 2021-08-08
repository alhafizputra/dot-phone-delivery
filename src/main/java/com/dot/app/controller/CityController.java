package com.dot.app.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dot.app.exception.DataNotFoundException;
import com.dot.app.model.City;
import com.dot.app.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	private static final Logger LOGGER=LoggerFactory.getLogger(CityController.class);
	
	@Autowired
	CityService cityService;
	
	@GetMapping()
	public ResponseEntity<List<City>> getAllCity() throws IOException {
		LOGGER.info("getAllCity started");
		List<City> cityList = cityService.getAllCity();
		LOGGER.info("getAllCity completed");
		return new ResponseEntity<List<City>>(cityList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<City> getCity(@PathVariable("id") int id) throws DataNotFoundException {
		LOGGER.info("getCity started");
		City city = cityService.getCity(id);
		LOGGER.info("getCity completed");
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
}
