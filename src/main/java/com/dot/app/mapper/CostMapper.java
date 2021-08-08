package com.dot.app.mapper;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.dot.app.model.Cost;

@Service
public class CostMapper {
	
	public Cost mapCost(JSONObject costObject) {
		System.out.println("=================");
		System.out.println(costObject.get("query"));
		int origin = Integer.valueOf(costObject.getJSONObject("query").get("origin").toString());
		int destination = Integer.valueOf(costObject.getJSONObject("query").get("destination").toString());
		int weight = Integer.valueOf(costObject.getJSONObject("query").get("weight").toString());
		String courier = costObject.getJSONObject("query").get("courier").toString();
		JSONObject results = costObject.getJSONArray("results").getJSONObject(0);
		Cost cost = new Cost(origin, destination, weight, courier, results.toString());
		return cost;
	}
	
	public JSONObject mapCostResultToJSON(String results) {
		JSONObject json = new JSONObject(results);
		System.out.println("===json: " + json);
		return json;
	}
}
