package com.dgv.dao;

import java.sql.SQLException;

import com.dgv.pojo.Customer;

public interface OrderDao {

	Integer getOrderId(Customer customer) throws SQLException;
}
