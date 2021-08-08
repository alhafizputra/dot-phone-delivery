package com.dot.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dot.app.model.Cost;
import com.dot.app.service.CostService;

@RestController
@RequestMapping("/cost")
public class CostController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(CityController.class);
	
	@Autowired
	CostService costService;

	@PostMapping()
	public ResponseEntity<Object> getCost(@RequestBody Cost costReqPayload) {
		LOGGER.info("getCost started");
		Object result = costService.getCost(costReqPayload);
		LOGGER.info("getCost completed");
		return ResponseEntity.status(HttpStatus.OK).body(result.toString());
	}
}
