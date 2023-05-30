package com.dgv.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dgv.dao.OrderDao;
import com.dgv.pojo.Customer;
import com.dgv.query.Query;
import com.dgv.utils.DBUtils;

public class OrderDaoImpl implements OrderDao {

	Connection connection;
	PreparedStatement preparedStatement;
	@Override
	public Integer getOrderId(Customer customer) throws SQLException {
		connection=DBUtils.main();
		Integer orderId = null;
		preparedStatement=connection.prepareStatement(Query.gettingOrderId);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			orderId = resultSet.getInt("orderId");
		}
		
		return orderId;
	}

}
