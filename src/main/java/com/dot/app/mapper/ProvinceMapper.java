package com.dot.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.dot.app.model.Province;

@Service
public class ProvinceMapper {

	public Province mapProvince(JSONObject provinceObject) {
		Province province = new Province(Integer.valueOf(provinceObject.getJSONObject("province_id").toString()),
				provinceObject.getJSONObject("province").toString());
		return province;
	}

	public List<Province> mapProvinceList(JSONArray provinceArray) {
		List<Province> provinceList = new ArrayList<>();
		Province province;
		for (int i = 0; i < provinceArray.length(); i++) {
			JSONObject provinceObject = provinceArray.getJSONObject(i);
			province = new Province(Integer.valueOf(provinceObject.get("province_id").toString()),
					provinceObject.get("province").toString());
			provinceList.add(province);
		}
		return provinceList;
	}
}
