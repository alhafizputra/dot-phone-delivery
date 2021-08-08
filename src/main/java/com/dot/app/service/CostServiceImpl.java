package com.dot.app.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dot.app.client.RajaOngkirClient;
import com.dot.app.mapper.CostMapper;
import com.dot.app.model.Cost;
import com.dot.app.repo.CostRepo;

@Service
public class CostServiceImpl implements CostService {
	
	@Autowired
	CostRepo costRepo;

	@Autowired
	RajaOngkirClient rajaOngkirClient;

	@Autowired
	CostMapper costMapper;

	@Override
	public Object getCost(Cost costReqPayload) {
		Cost cost = costRepo.findCostByOriginAndDestinationAndWeightAndCourier(costReqPayload.getOrigin(),
				costReqPayload.getDestination(), costReqPayload.getWeight(), costReqPayload.getCourier());
		JSONObject result;
		if (cost != null) {
			result = costMapper.mapCostResultToJSON(cost.getResults());
			return ResponseEntity.status(HttpStatus.OK).body(result.toString());
		}
		JSONObject costObject = rajaOngkirClient.getCost(costReqPayload);
		JSONObject costResult = costObject.getJSONObject("rajaongkir");
		cost = costMapper.mapCost(costResult);
		costRepo.save(cost);
		result = costMapper.mapCostResultToJSON(cost.getResults());

		return ResponseEntity.status(HttpStatus.OK).body(result.toString());
	}
}
