package com.dgv.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dgv.dao.AdminDao;
import com.dgv.pojo.Customer;
import com.dgv.pojo.Food;
import com.dgv.pojo.Inventory;
import com.dgv.pojo.Order;
import com.dgv.query.Query;
import com.dgv.utils.DBUtils;

public class AdminDaoImpl implements AdminDao {

	Connection connection;
	PreparedStatement preparedStatement;
	Integer numberOfFoodAdded=0;
	List<Food> listOfFoodInTheInventory=new ArrayList<>();
	@Override
	public Integer addInventory(List<Food> inventoryFoodList) throws SQLException {
	
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(Query.insertInventory);
		for(Food f:inventoryFoodList)
		{
			preparedStatement.setString(1, f.getFoodName());
			preparedStatement.setDouble(2, f.getFoodPrice());
			preparedStatement.setInt(3, f.getFoodQty());
			numberOfFoodAdded+=preparedStatement.executeUpdate();
		}
		connection.close();
		return numberOfFoodAdded;
		
	}
	@Override
	public List<Food> getInventory() throws SQLException {
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(Query.getInventory);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet==null)
		{
			System.out.println("First Fill The Inventory");
		}
		else
		{
			while(resultSet.next())
			{
				/*Collections.addAll(listOfFoodInTheInventory, new Food(resultSet.getInt("inventoryId"),resultSet.getString("foodName"),resultSet.getInt("foodQty")));*/
				Collections.addAll(listOfFoodInTheInventory, new Food(resultSet.getInt("inventoryId"),resultSet.getString("foodName"),resultSet.getInt("foodQuantity"),resultSet.getDouble("foodPrice")));
			}
		}
		connection.close();
		return listOfFoodInTheInventory;
	}
	@Override
	public List<Customer> getDetailsOfCustomer() throws SQLException {
		List<Customer>customerDetails=new ArrayList<>();
		String query="select customerId,customerUserName,customerRole from PRANAV_DESAI_CUSTOMER";
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(query);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			customerDetails.add(new Customer(resultSet.getInt("customerId"),resultSet.getString("customerUserName"),resultSet.getString("customerRole")));
		}
		return customerDetails;
	}
	@Override
	public List<Order> getOrderDetails(Integer customerId) throws SQLException {
		List<Order> orderOfParticularCust=new ArrayList<>();
		String query="Select bill from PRANAV_DESAI_ORDER where custId = ?";
		//String query="select sum(bill) from PRANAV_DESAI_ORDER GROUP BY custId=?";
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, customerId);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
				orderOfParticularCust.add(new Order( resultSet.getDouble("bill")));
		}
		return orderOfParticularCust;
	}
	@Override
	public void deleteProductFromInventory(String foodName) throws SQLException {
		String query="delete from PRANAV_DESAI_INVENTORY WHERE foodName = ?";
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, foodName);
		preparedStatement.executeUpdate();
		connection.close();
		
	}
	
	

	

}
