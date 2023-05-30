package com.dgv.pojo;

public class Inventory {

	private String foodName;
	private Double foodPrice;
	private Integer foodQuantity;
	private Integer inventoryId;
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public Integer getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(Integer foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public Inventory(String foodName, Double foodPrice, Integer foodQuantity, Integer inventoryId) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		this.inventoryId = inventoryId;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(String foodName, Double foodPrice, Integer foodQuantity) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
	}
	
	
}


