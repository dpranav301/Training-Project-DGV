package com.dgv.dao;

import java.sql.SQLException;
import java.util.List;

import com.dgv.pojo.Customer;
import com.dgv.pojo.Food;
import com.dgv.pojo.Inventory;

public interface CustomerDao {
	void insertOrder(Integer customerId,Boolean paymentStatus) throws SQLException;
	void insertBillInOrder(Double totalBill,Integer orderId) throws SQLException;
	List<Food> showOrderDetails(Customer customer) throws SQLException;
	void deleteProduct(Integer orderId) throws SQLException;
	void updateInventory(Integer inventoryId,Integer foodQty) throws SQLException;
	void updateInventoryAfterOrderCancle(Integer inventoryId,Integer foodQty) throws SQLException;
	Integer getInventoryId(String foodName) throws SQLException;
	List<Food> getBill(Integer orderId) throws SQLException;
	
	void insertFoodTable(Integer foodQty,Integer inventoryId,Integer orderId) throws SQLException;
}
