package com.dgv.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgv.restaurant.model.Food;
import com.dgv.restaurant.model.Inventory;
import com.dgv.restaurant.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/inventory")
@CrossOrigin("http://localhost:3000")
@Slf4j
public class InventoryController {

	List<Inventory> listOfFood;
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/getAllFood")
	public List<Inventory> getAllFoodInTheInventory() {
		listOfFood = inventoryService.listOfFoodInTheInventory();
		return listOfFood;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFoodFromInventory(@PathVariable int id) {
		if (inventoryService.deleteFoodFromTheInventory(id))
			return new ResponseEntity<>("deleted", HttpStatus.OK);
		return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);

	}
	@PostMapping("/add")
	public ResponseEntity<?> addProductToInventory(@RequestBody Inventory inventory)
	{
		if(inventoryService.addInventory(inventory))
		{
			return new ResponseEntity<>("Added succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Not Added", HttpStatus.EXPECTATION_FAILED);
	}
}
