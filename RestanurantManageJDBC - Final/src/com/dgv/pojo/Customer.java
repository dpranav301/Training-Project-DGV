package com.dgv.pojo;

import java.util.Objects;

public class Customer {

	private Integer custId;
	private String custName;
	private String custPassword;
	private String role;
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
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Customer(Integer custId, String custName, String custPassword, String role) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custPassword = custPassword;
		this.role = role;
	}
	
	
	public Customer(String custName, String custPassword) {
		super();
		this.custName = custName;
		this.custPassword = custPassword;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(custName, custPassword, role);
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
		return Objects.equals(custName, other.custName) || Objects.equals(custPassword, other.custPassword)
				|| Objects.equals(role, other.role);
	}
	public Customer(Integer custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custPassword=" + custPassword + ", role="
				+ role + "]";
	}
	public Customer(Integer custId, String custName, String role) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.role = role;
	}
	
	
	
	
	
	
	
	
	
	
	
}
