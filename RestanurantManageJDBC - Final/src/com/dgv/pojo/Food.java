package com.dgv.pojo;

import java.util.Objects;

public class Food {

	private String foodName;
	private Double foodPrice;
	private Integer foodQty;
	private Integer orderId;
	private Integer foodId;
	public Food(String foodName, Double foodPrice, Integer foodQty, Integer orderId, Integer foodId) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQty = foodQty;
		this.orderId = orderId;
		this.foodId = foodId;
	}
	
	public Food(String foodName, Double foodPrice, Integer foodQty) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQty = foodQty;
	}
	
	public Food(Integer foodId,String foodName,Integer foodQty,Double foodPrice)
	{
		this.foodId=foodId;
		this.foodName=foodName;
		this.foodQty=foodQty;
		this.foodPrice=foodPrice;
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
	public Integer getFoodQty() {
		return foodQty;
	}
	public void setFoodQty(Integer foodQty) {
		this.foodQty = foodQty;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(foodName);
	}
	//@Override
	/*public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(foodId, other.foodId) || Objects.equals(foodName, other.foodName)
				|| Objects.equals(foodPrice, other.foodPrice) || Objects.equals(foodQty, other.foodQty)
				|| Objects.equals(orderId, other.orderId);
	}*/
	

	public Food(String foodName) {
		super();
		this.foodName = foodName;
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
		return Objects.equals(foodName, other.foodName);
	}

	public Food(String foodName, Integer orderId,Integer foodQty) {
		super();
		this.foodName = foodName;
		this.orderId = orderId;
		this.foodQty=foodQty;
	}

	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodQty=" + foodQty + ", orderId="
				+ orderId + ", foodId=" + foodId + "]";
	}

	
	
	
	
	
	
	
}
