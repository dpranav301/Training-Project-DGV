package com.dgv.pojo;


import java.util.List;

public class Inventory {

	private List<Food> inventoryFood;
	
	

	public List<Food> getInventoryFood() {
		return inventoryFood;
	}

	public void setInventoryFood(List<Food> inventoryFood) {
		this.inventoryFood = inventoryFood;
	}

	

	public Inventory(List<Food> inventoryFood) {
		super();
		this.inventoryFood = inventoryFood;
		
	}
	
	//owner will fill the Inventory
	public void fillInventory()
	{
		/*
		 * inventoryFood = new ArrayList<>(); Collections.addAll(inventoryFood, new
		 * Food("Dosa", 2), new Food("Idli", 1), new Food("DalVada", 50), new
		 * Food("Samosa",60), new Food("BurjiPaav", 70), new Food("Poha",80));
		 * System.out.println("Inventory filled Successfully");
		 */
	}
	
	
	//Show Current Inventory
	public List<Food> showInventory()
	{
		return this.inventoryFood;
	}

	public Inventory() {
		
	}
	
	
	
	
	
	
}
