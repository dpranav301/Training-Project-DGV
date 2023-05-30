package com.dgv.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dgv.dao.AdminDao;
import com.dgv.dao.CustomerDao;
import com.dgv.dao.FoodDao;
import com.dgv.daoImpl.AdminDaoImpl;
import com.dgv.daoImpl.CustomerDaoImpl;
import com.dgv.daoImpl.FoodDaoImpl;
import com.dgv.daoImpl.OrderDaoImpl;
import com.dgv.pojo.Customer;
import com.dgv.pojo.Food;
import com.dgv.pojo.Order;

public class CustomerService {

	Scanner scanner=new Scanner(System.in);
	Integer howManyFoodOrder;
	String foodName;
	Integer foodQuantity;
	//Integer orderId=0;
	String orderConfirm;
	
	List<Food> inventoryList=new ArrayList<>();
	AdminService adminService=new AdminService();
	AdminDao adminDao=new AdminDaoImpl();
	CustomerDao customerDao=new CustomerDaoImpl();
	FoodDao foodDao=new FoodDaoImpl();
	public void orderFood(Customer customer) throws SQLException
	{
		Integer orderId=0;
		Double totalBill=0.0;
		//Here we get the inventory details to check whether it is empty or not
		inventoryList=adminDao.getInventory();
		System.out.println("How Many Food You want To Order");
		howManyFoodOrder=scanner.nextInt();
		scanner.nextLine();
		if(inventoryList.isEmpty())
		{
			System.out.println("inventory List is Empty");
		}
		else
		{
		while(howManyFoodOrder!=0)
		{
			List<Food> foodDetails=new ArrayList<>();
			foodDetails=new AdminDaoImpl().getInventory();
			adminService.Menu();
			System.out.println("Enter food Name");
			foodName=scanner.nextLine();
			Food f=new Food(foodName);
			System.out.println(f);
			//Before ordering that food we checck inside the inventory whether it is present in the inventory or not
			if(foodDetails.contains(f))
			{
				Integer index=foodDetails.indexOf(f);
				f=foodDetails.get(index);
				if(f.getFoodQty()==0)
				{
					System.out.println(foodName+" is exhuasted order another dish");
					break;
				}
			}
				System.out.println("Enter quantity");
				foodQuantity=scanner.nextInt();
				scanner.nextLine();
				System.out.println("You confirm this food will be in  Your Order write Yes and to Cancle write No");
				orderConfirm=scanner.nextLine();
				if(orderConfirm.equalsIgnoreCase("No"))
				{
					System.out.println("Cancle");
					break;
				}
				//After confirming one order will be created for that partcular customer for that particular food
				new CustomerDaoImpl().insertOrder(customer.getCustId(),false);
				//This is basically to calculate bill of the customer we need orderId
				orderId=new OrderDaoImpl().getOrderId(customer);
				
				Integer inventoryId = null;
				for(Food food:foodDetails) {
					if(food.getFoodName().equals(foodName)) 
					{
						inventoryId = food.getFoodId();
						new CustomerDaoImpl().insertFoodTable(food.getFoodQty(),orderId,inventoryId);
						totalBill=totalBill+(food.getFoodPrice()*foodQuantity);
						//After calculating the bill we update the order table bill column
						new CustomerDaoImpl().insertBillInOrder(totalBill, orderId);
						//Also here the qty of that particular food get updated in the inventory
						new CustomerDaoImpl().updateInventory(inventoryId, foodQuantity);
						//After all above operation we update Food table that contains what food customer has order
						foodDao.addFoodDao(foodQuantity,orderId,inventoryId);
						
					}
				}
			
			
			howManyFoodOrder--;
		}
		
		customerDao.insertBillInOrder(totalBill,orderId);
		}
		}
		
	public void seeBillOfCustomer(Customer customer) throws SQLException 
	{
		Double totalbill=0.0;
		List<Customer> customers=new ArrayList<>();
		List<Order> orders=new ArrayList<>();
		customers=new AdminDaoImpl().getDetailsOfCustomer();
		orders=new AdminDaoImpl().getOrderDetails(customer.getCustId());
		for(Order order : orders) {
			totalbill+=order.getBill();
			
		}
		//System.out.println("Total Bill of "+customer.getCustName()+" is "+totalbill);
		System.out.println("Bill of The customer "+customer.getCustName()+" "+(orders.get(orders.size() - 1).getBill()));
		
	}
	
}
