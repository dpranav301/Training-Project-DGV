package com.dgv.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dgv.dao.AdminDao;
import com.dgv.daoImpl.AdminDaoImpl;
import com.dgv.pojo.Customer;
import com.dgv.pojo.Food;
import com.dgv.pojo.Inventory;
import com.dgv.pojo.Order;

public class AdminService {

	private String foodName;
	private Double foodPrice;
	private Integer foodQty;
	private AdminDao adminDao;
	private Customer customer;
	//private Inventory inventory;
	private Food food;
	private List<Food> inventoryFoodList = new ArrayList<>();
	Scanner scanner=new Scanner(System.in);
	public AdminService()
	{
		adminDao=new AdminDaoImpl();
	}
	//This method is to take the Food from Admin and store them in a inventory
	public void addInventoryService() throws SQLException
	{
		System.out.println("Enter How Many Product You Want To Add in The Inventory");
		Integer howManyProduct=scanner.nextInt();
		scanner.nextLine();
		while(howManyProduct!=0)
		{
			System.out.println("Enter Food Name");
			foodName=scanner.nextLine();
			System.out.println("Enter Food Price");
			foodPrice=scanner.nextDouble();
			scanner.nextLine();
			System.out.println("Enter the food Quantity");
			foodQty=scanner.nextInt();
			scanner.nextLine();
			food=new Food(foodName, foodPrice, foodQty);
			System.out.println("Are Sure You want To this food In the Inventory then write Yes otherwise No");
			String choice=scanner.nextLine();
			if(choice.equalsIgnoreCase("Yes"))
			{
				inventoryFoodList.add(food);
				System.out.println(inventoryFoodList);
			}
			else
			{
				System.out.println(foodName+" is Not Added in the Inventory");
			}
			howManyProduct--;
		}
		System.out.println("Number of Food added are "+new AdminDaoImpl().addInventory(inventoryFoodList));
	}
	
	//From This method we get Details of inventory
	public void getInventoryService() throws SQLException
	{
		inventoryFoodList=new AdminDaoImpl().getInventory();
		System.out.printf("%15s%15s%15s\n","foodId","foodName","foodQty");
		for(Food f:inventoryFoodList)
		{
			System.out.printf("%15s%15s%15s\n",f.getFoodId(),f.getFoodName(),f.getFoodQty());
		}
	}
	//This is method is for customer to show Menu before ordering any Food
	public void Menu() throws SQLException
	{
		inventoryFoodList=new AdminDaoImpl().getInventory();
		System.out.printf("%15s%15s%15s\n","foodId","foodName","foodPrice");
		for(Food f:inventoryFoodList)
		{
			System.out.printf("%15s%15s%15s\n",f.getFoodId(),f.getFoodName(),f.getFoodPrice());
		}
	}
	//This is method where admin can see bill of customer
	public void showListOfCustomer() throws SQLException 
	{
		Double totalbill=0.0;
		List<Customer> customers=new ArrayList<>();
		List<Order> orders=new ArrayList<>();
		customers=new AdminDaoImpl().getDetailsOfCustomer();
		for(Customer c:customers)
		{
			
			System.out.printf("%15s%15s\n",c.getCustId(),c.getCustName());
			
			
		}
		System.out.println("Enter the Id of the customer whos details to be see");
		Integer customerId=scanner.nextInt();
		scanner.nextLine();
		orders=new AdminDaoImpl().getOrderDetails(customerId);
		//System.out.printf("%15s%15s%\n","Order ID","Order Bill");
		System.out.println("OrderID   "+" "+"OrderBill");
		for(Order order : orders) {
			//System.out.printf("%15s%15s%\n",order.getOrderId(),order.getBill());
			totalbill+=order.getBill();
			
		}
		System.out.println("Total Bill is equal to="+totalbill);
		
	}
	//To Delete Food From the inventory
	public void deleteProductFromInventory() throws SQLException
	{
		
		System.out.println("The food Present in the Inventory is as follows");
		inventoryFoodList=new AdminDaoImpl().getInventory();
		List<Food> foods=new ArrayList<>();
		//System.out.println(inventoryFoodList);
		System.out.printf("%15s%15s%15s\n","foodId","foodName","foodPrice");
		for(Food f:inventoryFoodList)
		{
			System.out.printf("%15s%15s%15s\n",f.getFoodId(),f.getFoodName(),f.getFoodPrice());
			foods.add(new Food(f.getFoodName()));
		}
		//adminService.Menu();
		System.out.println("Enter Name of Food You Want to delete");
		String name=scanner.nextLine();
		Food foodSearch=new Food(name);
		
		if(foods.contains(foodSearch)) {
			new AdminDaoImpl().deleteProductFromInventory(name);
		}	
		else
		{
			System.out.println("You choose Product which is not in the Inventory");
		}
		
	}

}
