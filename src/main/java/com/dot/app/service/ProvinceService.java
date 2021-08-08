package com.dot.app.service;

import java.util.List;

import com.dot.app.exception.DataNotFoundException;
import com.dot.app.model.Province;

public interface ProvinceService {
	List<Province> getAllProvince();
	Province getProvince(int id) throws DataNotFoundException;
}
