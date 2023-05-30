package com.dgv.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgv.restaurant.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

	
}
