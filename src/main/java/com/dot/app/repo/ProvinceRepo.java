package com.dot.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dot.app.model.Province;

@Repository
public interface ProvinceRepo extends JpaRepository<Province, Integer> {
	public Province findProvinceByProvinceId(int id);
}
