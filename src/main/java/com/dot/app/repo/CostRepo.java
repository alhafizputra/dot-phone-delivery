package com.dot.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dot.app.model.Cost;

@Repository
public interface CostRepo extends JpaRepository<Cost, Integer> {
	public Cost findCostByOriginAndDestinationAndWeightAndCourier(int origin, int destination, int weight,
			String courier);
}
