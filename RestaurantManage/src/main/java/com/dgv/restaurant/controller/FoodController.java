package com.dgv.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgv.restaurant.dtos.FoodDto;
import com.dgv.restaurant.service.FoodService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/order")
@Slf4j
public class FoodController {

	@Autowired
	private FoodService foodService;

	@PostMapping("place/{custId}")
	public ResponseEntity<?> placeOrder(@RequestBody FoodDto orderDetails, @PathVariable Integer custId) {
		
		System.out.println(orderDetails);
		System.out.println(custId);
		if (foodService.placeOrder(orderDetails, custId))
			return new ResponseEntity<>("placed", HttpStatus.OK);
		return new ResponseEntity<>("failed", HttpStatus.EXPECTATION_FAILED);
	}

}
