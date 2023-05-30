package com.dgv.query;

public class Query {

	//This Query is for Login and Registration purpose
	public static final String insertUser="insert into PRANAV_DESAI_CUSTOMER(customerId,customerUserName,customerPassword,customerRole) values (default,?,?,'customer')";
	public static final String selectUser="select * from PRANAV_DESAI_CUSTOMER";
	
	//This are Admin Query
	public static final String insertInventory="insert into PRANAV_DESAI_INVENTORY(foodName, foodPrice, foodQuantity,inventoryId) values (?,?,?,default)";
	public static final String getInventory="select inventoryId,foodName,foodQuantity,foodPrice from PRANAV_DESAI_INVENTORY";
	
	//This is for Customer Query
	
	public static final String getCustomerDetails="select customerId from PRANAV_DESAI_CUSTOMER where customerUserName=?";
	
	//This is to create order
	public static final String createOrder="Insert into PRANAV_DESAI_ORDER(orderId,custId,status) values(default,?,?)";
	public static final String gettingOrderId="select orderId from PRANAV_DESAI_ORDER order by orderId desc limit 1 ";
	public static final String insertBillInOrder="update PRANAV_DESAI_ORDER SET bill=? where orderId=?";
	public static final String addFoodIntoFoodTable="INSERT INTO `training_database`.`PRANAV_DESAI_FOOD` (`foodQty`, `orderId`, `foodId`, `inventoryId`) values(?,?,default,?)";
	}
