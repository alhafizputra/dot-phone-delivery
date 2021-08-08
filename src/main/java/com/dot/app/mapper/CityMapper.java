package com.dot.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.dot.app.model.City;

@Service
public class CityMapper {
	public City mapCity(JSONObject provinceObject) {
		City city = new City(Integer.valueOf(provinceObject.getJSONObject("city_id").toString()),
				provinceObject.getJSONObject("city_name").toString(),
				Integer.valueOf(provinceObject.getJSONObject("province_id").toString()),
				provinceObject.getJSONObject("province").toString(), provinceObject.getJSONObject("type").toString(),
				provinceObject.getJSONObject("postal_code").toString());
		return city;
	}

	public List<City> mapCityList(JSONArray provinceArray) {
		List<City> cityList = new ArrayList<>();
		City city;
		for (int i = 0; i < provinceArray.length(); i++) {
			JSONObject provinceObject = provinceArray.getJSONObject(i);
//			System.out.println("provinceObject: " + provinceObject);
//			System.out.println("provinceObject: " + provinceObject.get("province"));
			city = new City(Integer.valueOf(provinceObject.get("city_id").toString()),
					provinceObject.get("city_name").toString(),
					Integer.valueOf(provinceObject.get("province_id").toString()),
					provinceObject.get("province").toString(),
					provinceObject.get("type").toString(),
					provinceObject.get("postal_code").toString());
			cityList.add(city);
		}
		return cityList;
	}
}
