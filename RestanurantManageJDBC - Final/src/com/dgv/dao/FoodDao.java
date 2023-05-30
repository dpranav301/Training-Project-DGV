package com.dgv.dao;

import java.sql.SQLException;

public interface FoodDao {

	void addFoodDao(Integer foodQty,Integer orderId,Integer inventoryId) throws SQLException ;
}

