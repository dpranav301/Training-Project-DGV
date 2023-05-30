package com.dgv.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dgv.dao.FoodDao;
import com.dgv.query.Query;
import com.dgv.utils.DBUtils;

public class FoodDaoImpl implements FoodDao {

	Connection connection;
	PreparedStatement preparedStatement;
	@Override
	public void addFoodDao(Integer foodQty,Integer orderId,Integer inventoryId) throws SQLException {
	
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(Query.addFoodIntoFoodTable);
		preparedStatement.setInt(1, foodQty);
		preparedStatement.setInt(2, orderId);
		preparedStatement.setInt(3, inventoryId);
		Integer numberOfRowsAffected=preparedStatement.executeUpdate();
		//System.out.println("Number of rows Affected="+numberOfRowsAffected);
		
	}

}
