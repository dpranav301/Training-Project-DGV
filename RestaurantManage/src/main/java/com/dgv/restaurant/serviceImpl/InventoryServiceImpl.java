package com.dgv.restaurant.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.restaurant.model.Food;
import com.dgv.restaurant.model.Inventory;
import com.dgv.restaurant.repository.InventoryRepo;
import com.dgv.restaurant.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;

	@Override
	public List<Inventory> listOfFoodInTheInventory() {
		List<Inventory> foodList = inventoryRepo.findAll();
		return foodList;
	}

	@Override
	public boolean deleteFoodFromTheInventory(Integer id) {
		if (inventoryRepo.existsById(id)) {
			inventoryRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Boolean addInventory(Inventory inventory) {
		if (inventoryRepo.save(inventory) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Inventory getById(Integer id) {
		return inventoryRepo.findById(id).orElseThrow();
	}
	@Override
	public void updateInventoryAfterOrder(Integer qtyToReduce,Integer inventoryId)
	{
		Inventory inventoryTobeUpdated=inventoryRepo.findById(inventoryId).orElseThrow();
		inventoryTobeUpdated.setFoodQuantity(inventoryTobeUpdated.getFoodQuantity()-qtyToReduce);
	}
	
}
