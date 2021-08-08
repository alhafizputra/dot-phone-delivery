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
import com.dot.app.model.Province;
import com.dot.app.service.ProvinceService;

@RestController
@RequestMapping("/province")
public class ProvinceController {
	private static final Logger LOGGER=LoggerFactory.getLogger(CityController.class);
	
	@Autowired
	ProvinceService provinceService;

	@GetMapping()
	public ResponseEntity<List<Province>> getAllProvince() throws IOException {
		LOGGER.info("getAllProvince started");
		List<Province> provinceList = provinceService.getAllProvince();
		LOGGER.info("getAllProvince completed");
		return new ResponseEntity<List<Province>>(provinceList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Province> getProvince(@PathVariable("id") int id) throws DataNotFoundException {
		LOGGER.info("getProvince started");
		Province province = new Province();
		province = provinceService.getProvince(id);
		LOGGER.info("getProvince completed");
		return new ResponseEntity<Province>(province, HttpStatus.OK);
	}
}
