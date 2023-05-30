package com.dgv.restaurant.service;

import org.springframework.stereotype.Service;

import com.dgv.restaurant.dtos.FoodDto;

public interface FoodService {

	public Boolean placeOrder(FoodDto orderDetails,Integer custId);

}
