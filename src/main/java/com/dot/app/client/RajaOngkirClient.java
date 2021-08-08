package com.dot.app.client;

import org.json.JSONObject;

import com.dot.app.model.Cost;

public interface RajaOngkirClient {
	JSONObject getProvince(int id);
	JSONObject getCity(int id);
	JSONObject getCost(Cost costReqPayload);
}
