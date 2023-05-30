package com.dgv.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dgv.dao.CustomerDao;
import com.dgv.pojo.Customer;
import com.dgv.pojo.Food;
import com.dgv.query.Query;
import com.dgv.utils.DBUtils;

public class CustomerDaoImpl implements CustomerDao{
	private PreparedStatement preparedStatement;
	Connection connection;
	@Override
	public void insertOrder(Integer customerId, Boolean paymentStatus) throws SQLException {
		connection = DBUtils.main();
		preparedStatement = connection.prepareStatement(Query.createOrder);
		preparedStatement.setInt(1, customerId);
		preparedStatement.setBoolean(2, paymentStatus);
		Integer rowsInserted = preparedStatement.executeUpdate();
		System.out.println("Number of Order inserted = "+rowsInserted);
		connection.close();
	}
	
	public void insertBillInOrder(Double totalBill,Integer orderId) throws SQLException
	{
		connection=DBUtils.main();
		preparedStatement=connection.prepareStatement(Query.insertBillInOrder);
		preparedStatement.setDouble(1,totalBill);
		preparedStatement.setInt(2,orderId);
		Integer rowInserted=preparedStatement.executeUpdate();
		//System.out.println("Number of data updated="+rowInserted);
		connection.close();
		
	}

	@Override
	public List<Food> showOrderDetails(Customer customer) throws SQLException {
		List<Food>foodName=new ArrayList<>();
		connection=DBUtils.main();
		String query="select t1.foodName,t3.orderId,t2.foodQty from PRANAV_DESAI_INVENTORY t1 join PRANAV_DESAI_FOOD t2 on t1.inventoryId=t2.inventoryId join PRANAV_DESAI_ORDER t3 on t2.orderId=t3.orderId where t3.custId=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, customer.getCustId());
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			foodName.add(new Food(resultSet.getString("foodName"),resultSet.getInt("orderId"),resultSet.getInt("foodQty")));
		}
		
		return foodName;
	}
	public void deleteProduct(Integer orderId) throws SQLException
	{
		connection=DBUtils.main();
		String query="delete from PRANAV_DESAI_ORDER where orderId=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, orderId);
		preparedStatement.execute();
		System.out.println("Product is Removed from your Order");
	}

	@Override
	public void updateInventory(Integer inventoryId, Integer foodQty) throws SQLException {
		connection=DBUtils.main();
		String query="UPDATE `training_database`.`PRANAV_DESAI_INVENTORY` SET foodQuantity = foodQuantity - ? where inventoryId=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, foodQty);
		preparedStatement.setInt(2, inventoryId);
		preparedStatement.executeUpdate();
		System.out.println("Inventory Updated succesfully");
		
	}

	@Override
	public void updateInventoryAfterOrderCancle(Integer inventoryId, Integer foodQty) throws SQLException {
		connection=DBUtils.main();
		String query="UPDATE `training_database`.`PRANAV_DESAI_INVENTORY` SET foodQuantity = foodQuantity + ? where inventoryId=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, foodQty);
		preparedStatement.setInt(2, inventoryId);
		preparedStatement.executeUpdate();
		System.out.println("Inventory Updated succesfully");
		
	}

	@Override
	public Integer getInventoryId(String foodName) throws SQLException {
		
		connection=DBUtils.main();
		String query="select inventoryId from PRANAV_DESAI_INVENTORY WHERE foodName=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, foodName);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			return resultSet.getInt("inventoryId");
		}
		return null;
	}
	public List<Food> getBill(Integer orderId) throws SQLException
	{
		List<Food> foodDetails=new ArrayList<>();
		connection=DBUtils.main();
		String query="select I.foodName,I.foodPrice,F.foodQty from PRANAV_DESAI_INVENTORY I ,PRANAV_DESAI_FOOD F where F.inventoryId=I.inventoryId and orderId=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, orderId);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			foodDetails.add(new Food(resultSet.getString("foodName"),resultSet.getDouble("foodPrice"),resultSet.getInt("foodQty")));
		}
		return foodDetails;
	}

	@Override
	public void insertFoodTable(Integer foodQty,Integer inventoryId,Integer orderId) throws SQLException {
		connection=DBUtils.main();
		String query="Insert into PRANAV_DESAI_FOOD(foodId,foodQty,inventoryId,orderId) values(default,?,?,?)";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, foodQty);
		preparedStatement.setInt(2, inventoryId);
		preparedStatement.setInt(3, orderId);
		Integer affectedRow=preparedStatement.executeUpdate();
		
		//System.out.println("Food added with affected Rows = "+affectedRow);
	}

}
