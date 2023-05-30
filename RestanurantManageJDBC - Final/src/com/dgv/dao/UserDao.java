package com.dgv.dao;

import java.sql.SQLException;
import java.util.List;

import com.dgv.pojo.Customer;

public interface UserDao {

	Integer registerUserDao(Customer customer) throws SQLException;
	
	List<Customer> loginUserDao() throws SQLException;
	
}
