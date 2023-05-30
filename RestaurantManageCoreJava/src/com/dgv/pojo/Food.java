package com.dgv.pojo;

import java.util.Objects;

public class Food {

	private Integer foodId;
	
	private String foodName;
	
	private Double foodPrice;
	
	private Integer qty;
	

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

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

	public Food(Integer foodId, String foodName, Double foodPrice) {
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		
	}

	public Food(Integer foodId)
	{
		this.foodId=foodId;
	}
	
	//This is for inventory filling
	public Food(String foodName, Integer qty) {
		super();
		this.foodName = foodName;
		this.qty = qty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foodId);
	}

	//To Check The selected item is present or not
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(foodId, other.foodId);
	}*/
	

	public Food(Integer foodId, String foodName, Double foodPrice, Integer qty) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.qty = qty;
	}
	
	

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(foodId, other.foodId);
	}
	
	

	public Food(String foodName) {
		super();
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", qty=" + qty + "]";
	}
	
	

	
	
	
		
}
