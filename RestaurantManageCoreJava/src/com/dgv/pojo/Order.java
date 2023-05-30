package com.dgv.pojo;

import java.util.List;
import java.util.Objects;

public class Order {

	private Integer orderId;
	
	private List<Food> foods;
	private Double billOfCustomer;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	

	public Double getBillOfCustomer() {
		return billOfCustomer;
	}

	public void setBillOfCustomer(Double billOfCustomer) {
		this.billOfCustomer = billOfCustomer;
	}

	public Order(Integer orderId,List<Food> foods, Double billOfCustomer) {
		super();
		this.orderId=orderId;
		this.foods = foods;
		this.billOfCustomer = billOfCustomer;
	}

	/*
	 * @Override public int hashCode() { return Objects.hash(billOfCustomer, foods,
	 * orderId); }
	 */

	
	
	

	
	
	
}
