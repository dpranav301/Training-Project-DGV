package com.dgv.pojo;

import java.util.List;
import java.util.Objects;

public class Customer {
	
	private Integer custId;
	private String custName;
	private Order order;
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Customer(Integer custId, String custName, Order order) {

		this.custId = custId;
		this.custName = custName;
		this.order = order;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer custId) {
		
		this.custId = custId;
	}
	public Customer(String custName) {
		super();
		this.custName = custName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(custName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(custName, other.custName);
	}
	
	
	
	
	
	
	
	
	
}
