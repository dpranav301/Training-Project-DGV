package com.dgv.dao;

import java.sql.SQLException;
import java.util.List;

import com.dgv.pojo.Customer;
import com.dgv.pojo.Food;
import com.dgv.pojo.Inventory;
import com.dgv.pojo.Order;

public interface AdminDao {

	public Integer addInventory(List<Food> inventoryFoodList) throws SQLException;
	
	public List<Food> getInventory() throws SQLException;
	
	public List<Customer> getDetailsOfCustomer() throws SQLException;
	
	public List<Order> getOrderDetails(Integer custId) throws SQLException;
	
	public void deleteProductFromInventory(String foodName) throws SQLException;
}
