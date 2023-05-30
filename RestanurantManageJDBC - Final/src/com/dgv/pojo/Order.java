package com.dgv.pojo;

public class Order {

	private Integer orderId;
	private Double bill;
	private Boolean status;
	private Integer custId;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Order(Integer orderId, Double bill, Boolean status, Integer custId) {
		super();
		this.orderId = orderId;
		this.bill = bill;
		this.status = status;
		this.custId = custId;
	}
	public Order(Integer orderId) {
		super();
		this.orderId = orderId;
	}
	public Order( Double bill) {
		super();
		
		this.bill = bill;
		
	}
	
	
	
}
