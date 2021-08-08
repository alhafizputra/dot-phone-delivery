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
import com.dot.app.mapper.ProvinceMapper;
import com.dot.app.model.Province;
import com.dot.app.repo.ProvinceRepo;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ProvinceServiceImpl.class);
	
	@Autowired
	ProvinceRepo provinceRepo;
	
	@Autowired
	RajaOngkirClient rajaOngkirClient;

	@Autowired
	ProvinceMapper provinceMapper;
	
	@Override
	public List<Province> getAllProvince() {
		List<Province> provinceList = new ArrayList<>();
		provinceList = provinceRepo.findAll();
		if (!provinceList.isEmpty()) {
			return provinceList;
		}
		JSONObject provinceObject = rajaOngkirClient.getProvince(0);
		JSONArray provinceArray = new JSONArray();
		provinceArray = provinceObject.getJSONObject("rajaongkir").getJSONArray("results");
		provinceList = provinceMapper.mapProvinceList(provinceArray);
		provinceRepo.saveAll(provinceList);
		
		return provinceList;
	}

	@Override
	public Province getProvince(int id) throws DataNotFoundException {
		Province province = provinceRepo.findProvinceByProvinceId(id);
		if (province != null) {
			return province;
		}
		JSONObject provinceObject = rajaOngkirClient.getProvince(0);
		JSONArray provinceArray = new JSONArray();
		provinceArray = provinceObject.getJSONObject("rajaongkir").getJSONArray("results");
		List<Province> provinceList = new ArrayList<>();
		provinceList = provinceMapper.mapProvinceList(provinceArray);
		provinceRepo.saveAll(provinceList);
		
		province = provinceRepo.findProvinceByProvinceId(id);
		if (province == null) {
			LOGGER.error("Province with id " + id + " not found");
			throw new DataNotFoundException("Province with id " + id + " not found");
		}
		return province;
	}
}
