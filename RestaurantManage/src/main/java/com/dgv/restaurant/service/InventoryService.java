package com.dgv.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgv.restaurant.model.Food;
import com.dgv.restaurant.model.Inventory;


public interface InventoryService {

	public List<Inventory> listOfFoodInTheInventory();

	public boolean deleteFoodFromTheInventory(Integer id);

	public Boolean addInventory(Inventory inventory);

	public Inventory getById(Integer id);
	void updateInventoryAfterOrder(Integer qtyToReduce,Integer inventoryId);

}
