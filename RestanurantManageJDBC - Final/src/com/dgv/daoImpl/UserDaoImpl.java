package com.dgv.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dgv.dao.UserDao;
import com.dgv.pojo.Customer;
import com.dgv.query.Query;
import com.dgv.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	Connection connection;
	PreparedStatement preparedStatement;
	
	@Override
	public Integer registerUserDao(Customer customer) throws SQLException {
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(Query.insertUser);
		preparedStatement.setString(1, customer.getCustName());
		preparedStatement.setString(2,customer.getCustPassword());
		Integer numberOfRowsAffected=preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		return numberOfRowsAffected;	
	}

	@Override
	public List<Customer> loginUserDao() throws SQLException {
	
		List<Customer> customerList=new ArrayList<>();
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(Query.selectUser);
		ResultSet customerResultSet=preparedStatement.executeQuery();
		while(customerResultSet.next()) {
			Collections.addAll(customerList, new Customer(customerResultSet.getInt("customerId"),customerResultSet.getString("customerUserName"),customerResultSet.getString("customerPassword"),customerResultSet.getString("customerRole")));
		}
		return customerList;
		
	}

	
	
}
