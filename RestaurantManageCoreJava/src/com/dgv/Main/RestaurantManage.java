package com.dgv.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import com.dgv.Constant.Constant;
import com.dgv.Exception.ProductOutOfStockException;
import com.dgv.pojo.Customer;
import com.dgv.pojo.Food;
import com.dgv.pojo.Inventory;
import com.dgv.pojo.Order;

public class RestaurantManage {
	// This Is to Remove The sysout sonarLint Problem
	private static final Logger logger = Logger.getLogger(RestaurantManage.class.getName());
	static Scanner scanner = new Scanner(System.in);
	private static List<Food> foodList = new ArrayList<>();// This List is to Add Menu
	// Inventory object
	private static Inventory inventory = new Inventory();
	private static Order order;
	private static List<Customer> customerHasOrderDish=new ArrayList<>();// List of Customer that has order something
	private static String custName = "";
	private static Integer custId = 0;
	private static String custPass = "";
	private static Customer customer;
	private static Integer index;
	private static List<Food> foods;
	//private static Double totalBill;
	// This Is to Remove The sysout sonarLint Problem
	private static class SimpleMessageFormatter extends Formatter {
		@Override
		public String format(LogRecord record) {
			return record.getMessage() + System.lineSeparator();
		}
	}

	public static void main(String[] args) throws ProductOutOfStockException {
		//Double totalBill;
		//foods=new ArrayList<>();
		Logger rootLogger = Logger.getLogger("");
		for (Handler handler : rootLogger.getHandlers()) {
			handler.setFormatter(new SimpleMessageFormatter());
		}
		
		// To Check whether user is admin or any normal user
		while (true) // NOSONAR
		{

			logger.info("=======>Welcome To Restaurant Management System<================");
			logger.info("Enter 1 for Login and 0 for Application close");
			Integer choiceForLoginOrExit = scanner.nextInt();
			scanner.nextLine();
			if (choiceForLoginOrExit == 1) {
				logger.info("Enter Your Name ");
				custName = scanner.nextLine();
				logger.info("Enter Your Password");
				custPass = scanner.nextLine();
			} else {
				logger.info("Application close");
				System.exit(0);
			}
			// This if for checking whethere given user is admin or not
			if (custName.equalsIgnoreCase(Constant.ADMIN) && custPass.equalsIgnoreCase(Constant.ADMIN)) {
				Boolean innerexitLoop = false;
				Integer innerChoice;

				logger.info("===================>welcome Admin<=======================");
				do {
					logger.info(
							"1.Create Inventory\n2.Current Inventory\n3.Bill\n4.Product You Want To delete\n5.logout");
					innerChoice = scanner.nextInt();
					scanner.nextLine();
					switch (innerChoice) {
					case 1:
						RestaurantManage.howManyProductAdminWantToAdd();
						innerexitLoop = true;
						break;

					case 2:
						RestaurantManage.showInventoryToAdmin();
						innerexitLoop = true;
						break;
					case 3:
						RestaurantManage.showBillOfAllCustomerToAdmin();
						innerexitLoop = true;
						break;
					case 4:
						RestaurantManage.deleteProductFromInventory();
						innerexitLoop = true;
						break;
					case 5:
						RestaurantManage.adminLogout();
						innerexitLoop = false;
						break;
					default:
						logger.info("Invalid Choice");

					}

				} while (innerexitLoop);
			} else if (!custName.equalsIgnoreCase(Constant.ADMIN) && !custPass.equalsIgnoreCase(Constant.ADMIN))
			{

				Double totalBill;
				//List<Food> foods;
				customerHasOrderDish=new ArrayList<>();
				// This is for autogeneration of foodId
				custId++;
				// This customer object is To Check whether this customer has order some food or
				// not
				customer = new Customer(custName);
				if (customerHasOrderDish.contains(customer)) {
					index = customerHasOrderDish.indexOf(customer);
					customer = customerHasOrderDish.get(index);
					foods = customer.getOrder().getFoods();
					totalBill = customer.getOrder().getBillOfCustomer();

				} else {
					customer = new Customer();// This List is for Generating FoodList of Customer
					foods = new ArrayList<>();
					totalBill = 0.0;
				}
				Boolean innerexitLoop = false;
				Integer innerChoice;
				logger.info("===========>Welcome " + custName + "<=================");
				do {
					innerexitLoop = false;
					logger.info("1.Order The Food\n2.See Bill\n3.Delete Product\n4.logout");
					innerChoice = scanner.nextInt();
					switch (innerChoice)
					{
					case 1:
						if (foodList.isEmpty()) {
							logger.info("Inventory is Empty");
						} 
						else
						{
							logger.info("How Many Dish You Want To Order");
							Integer numberOfOrder = scanner.nextInt();
							for (Integer i = 0; i < numberOfOrder; i++) {
								System.out.println("The Menu is As Follows and Place Order");
								System.out.printf("%15s%15s%15s\n", "Id", "Name", "Price");
								for (Food f : foodList) {
									System.out.printf("%15s%15s%15s\n", f.getFoodId(), f.getFoodName(),f.getFoodPrice());
								}
								logger.info("Enter Food Id");
								Integer foodId = scanner.nextInt();
								Food food = new Food(foodId);
								if(foodList.contains(food)) 
								{

									index = foodList.indexOf(food);
									food = foodList.get(index);

									// updating inventory
									// updating inventory
									for (Food f : foodList) {
										if (f.getFoodName().equalsIgnoreCase(food.getFoodName())) {
											Integer beforeOrderQty = f.getQty();
											try {
												if (beforeOrderQty == 0) {
													throw new ProductOutOfStockException(
															f.getFoodName() + " Get Exhausted Order Another Food");
												}
												else {
													//System.out.println(food.getFoodPrice());
													totalBill += food.getFoodPrice();
													foods.add(food);
													//System.out.println(totalBill);
													--beforeOrderQty;
													f.setQty(beforeOrderQty);
													logger.info("Updating Inventory");
												}
											} catch (Exception e) {
												logger.info(e.getMessage());
											}
										}

									}
								}
							}
								
						}
						// This if else is to modify the order of customer if customer exsist already
						if (customerHasOrderDish.contains(customer)) {
							order = customer.getOrder();
							order.setBillOfCustomer(totalBill);
						} else {
							order = new Order(custId, foods, totalBill);

							customer.setCustId(custId);
							customer.setCustName(custName);
							customer.setOrder(order);
							customerHasOrderDish.add(customer);
						}
						innerexitLoop=true;
						break;
					case 2:
						Customer cust = new Customer(custName);
						if (customerHasOrderDish.contains(cust)) 
						{
							index = customerHasOrderDish.indexOf(cust);
							cust = customerHasOrderDish.get(index);
							if (cust.getOrder().getBillOfCustomer() == 0) {
								System.out.println(cust.getOrder().getBillOfCustomer());
								logger.info("Please order first");
							} else 
							{
								/*logger.info(cust.getCustName() + "Your Bill is as Follows");
								/*System.out.printf("%15s%15s%15s\n","FoodId", Constant.FOODNAME, Constant.FOODPRICE);

								for (Food f : cust.getOrder().getFoods()) {
									System.out.printf("%15s%15s\n",f.getFoodId(), f.getFoodName(),
											f.getFoodPrice());

								}*/
								logger.info(custName + " Your Total Bill is "
										+ customerHasOrderDish.get(index).getOrder().getBillOfCustomer());
							}
						}

						else {
							logger.info("Order First");
						}
					
						innerexitLoop = true;
						break;
					case 3:
						customer = new Customer(custName);
						Integer customerIndex = customerHasOrderDish.indexOf(customer);
						if (index != -1) {
							logger.info("Enter The Name Of The Food You Want To Delete");
							logger.info(() -> String.format(Constant.FORMAT_LITERAL, "FoodId", Constant.FOODNAME, Constant.FOODPRICE));
							// Here we get food that has been order by each customer
							foods = customerHasOrderDish.get(index).getOrder().getFoods();
							for (Food f : foods) {
								logger.info(
										() -> String.format(Constant.FORMAT_LITERAL, f.getFoodId(), f.getFoodName(), f.getFoodPrice()));

							}
							// Id of The Food That user want To delete
							String foodNameYouWantToDelete = scanner.nextLine();
							scanner.nextLine();
							Food food=new Food(foodNameYouWantToDelete);
							// Here we get quantity of each food That we want to remove before remove from
							// list
							//Integer index=0;
							for(Food f:foodList)
							{
								Integer index=foodList.indexOf(food);
							}
							Integer inventoryQtyBeforeDelete = foodList.get(index).getQty();
							// After removing The product by customer it get added in the inventory again
							foodList.get(index).setQty(inventoryQtyBeforeDelete + 1);
							// When customer removes the product from his order then total bill will get
							// updated again
							customerHasOrderDish.get(customerIndex).getOrder()
									.setBillOfCustomer(customerHasOrderDish.get(customerIndex).getOrder().getBillOfCustomer()
											- foods.get(index).getFoodPrice());
							// Here actual product get remove from order of customer
							foods.removeIf(foo -> foo.getFoodName().equals(foodNameYouWantToDelete));
							// after modifying the order list set the order list
							customerHasOrderDish.get(customerIndex).getOrder().setFoods(foods);
						} else {
							System.out.println("You should Order first");
						}
						innerexitLoop=true;
						break;
					case 4:
						custName = "";
						custPass = "";
						logger.info("LogOut Successfully");
						innerexitLoop = false;
						break;
					default:
						logger.info("Invalid Choice");

					}
				} while (innerexitLoop);
			}
		}
	}

	public static void howManyProductAdminWantToAdd() {
		Integer foodId = 0;
		
		// This is code is to Use when we want to use logger from line 159 to 166 in
		// every method where we use sysout
		Logger rootLogger = Logger.getLogger("");
		for (Handler handler : rootLogger.getHandlers()) {
			handler.setFormatter(new SimpleMessageFormatter());
		}

		logger.info("Enter How Many Product ");
		Integer productNumber = scanner.nextInt();
		// Loop To Add Product In The Inventory
		while (productNumber != 0) {
			scanner.nextLine();

			logger.info("Enter Food Name ");
			String foodName = scanner.nextLine();
			logger.info("Enter food Quantity ");
			Integer qty = scanner.nextInt();
			scanner.nextLine();
			logger.info("Enter Food Price ");
			Double foodPrice = scanner.nextDouble();
			// scanner.nextLine();
			foodId++;
			foodList.add(new Food(foodId, foodName, foodPrice, qty));
			// To Add Inventory
			productNumber--;
		}
		inventory.setInventoryFood(foodList);
		logger.info("Inventory Added Succesfully");
	}

	public static void showInventoryToAdmin() {

		// This if else is to check whether Inventory is empty or Not
		if (foodList.isEmpty()) {
			logger.info("Fill The Inventory first");
		} else {
			logger.info("Current Inventory is as follows");
			logger.info(() -> String.format("%15s%15s%15s%15s%n", "Id", "Name", "Price", "Quantity"));
			for (Food f : foodList) {
				logger.info(() -> String.format("%15s%15s%15s%15s", f.getFoodId(), f.getFoodName(), f.getFoodPrice(),
						f.getQty()));
			}
		}
	}

	public static void showBillOfAllCustomerToAdmin() {

		if (customerHasOrderDish.isEmpty()) {
			logger.info("No Customer Has Order Dish Yet");
		} else {
			logger.info("Bill of customer");
			for (Customer c : customerHasOrderDish) {
				logger.info("Hello " + c.getCustName());
				order = c.getOrder();
				logger.info(() -> String.format("%15s%15s", Constant.FOODNAME, Constant.FOODPRICE));

				for (Food f : order.getFoods()) {
					logger.info(() -> String.format("%15s%15s", f.getFoodName(), f.getFoodPrice()));

				}
				logger.info("Your Total Bill is " + order.getBillOfCustomer());
				logger.info("================================================");
			}
		}
	}

	public static void deleteProductFromInventory() {
		if (foodList.isEmpty())
		{
			logger.info("Inventory is Empty");
		} 
		else 
		{
			logger.info("Enter the Id of The Product You want To Delete");
			RestaurantManage.showInventoryToAdmin();
			Integer IdOfProductYouWantToDelete = scanner.nextInt();
			Food foodYouWantToDelete = new Food(IdOfProductYouWantToDelete);

			if (foodList.contains(foodYouWantToDelete))
			{
				index = foodList.indexOf(foodYouWantToDelete);
				System.out.println(index);
				foodList.removeIf(f->f.getFoodId().equals(IdOfProductYouWantToDelete));
				inventory.setInventoryFood(foodList);
			}

			else
			{
				logger.info("You Have Enter Food That is Not Present in the Inventory");
			}
		}

	}

	public static void adminLogout() {
		custName = "";
		custPass = "";
		logger.info("Logout Successfully");
	}

	/*public static void howManyProductCustomerWantToOrder() {
		//Double totalBill = 0.0;
		if (foodList.isEmpty()) {
			logger.info("Inventory is Empty");
		} else {
			logger.info("How Many Dish You Want To Order");
			Integer numberOfOrder = scanner.nextInt();
			for (Integer i = 0; i < numberOfOrder; i++) 
			{
				logger.info("The Menu is As Follows and Place Order");
				logger.info(() -> String.format(Constant.FORMAT_LITERAL, "Id", "Name", "Price"));

				for (Food f : foodList) 
				{
					logger.info(() -> String.format(Constant.FORMAT_LITERAL, f.getFoodId(), f.getFoodName(),
							f.getFoodPrice()));

				}
				logger.info("Enter Food Id");
				Integer foodId = scanner.nextInt();
				Food food = new Food(foodId);
				if (foodList.contains(food)) 
				{

					index = foodList.indexOf(food);
					food = foodList.get(index);

					// updating inventory
					for (Food f : foodList) {
						if (f.getFoodName().equalsIgnoreCase(food.getFoodName())) {
							Integer beforeOrderQty = f.getQty();
							try {
								if (beforeOrderQty == 0) {
									throw new ProductOutOfStockException(
											f.getFoodName() + " Get Exhausted Order Another Food");
								} else {
									System.out.println(food.getFoodPrice());
									totalBill += food.getFoodPrice();
									foods.add(food);
									//System.out.println(totalBill);
									--beforeOrderQty;
									f.setQty(beforeOrderQty);
									logger.info("Updating Inventory");
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}

					}
				}
			}
		}
		// This if else is to modify the order of customer if customer exsist already
		if (customerHasOrderDish.contains(customer)) {
			order = customer.getOrder();
			order.setBillOfCustomer(totalBill);
		} else {
			order = new Order(custId, foods, totalBill);

			customer.setCustId(custId);
			customer.setCustName(custName);
			customer.setOrder(order);
			customerHasOrderDish.add(customer);

		}
	}*/

	/*public static void customerBill() {
		//System.out.println(customerHasOrderDish);
		Customer cust = new Customer(custName);
		if (customerHasOrderDish.contains(cust)) {
			index = customerHasOrderDish.indexOf(cust);
			cust = customerHasOrderDish.get(index);
			if (cust.getOrder().getBillOfCustomer() == 0) {
				System.out.println(cust.getOrder().getBillOfCustomer());
				logger.info("Please order first");
			} else {
				logger.info(cust.getCustName() + "Your Bill is as Follows");
				logger.info(
						() -> String.format(Constant.FORMAT_LITERAL, "FoodId", Constant.FOODNAME, Constant.FOODPRICE));

				for (Food f : cust.getOrder().getFoods()) {
					logger.info(() -> String.format(Constant.FORMAT_LITERAL, f.getFoodId(), f.getFoodName(),
							f.getFoodPrice()));

				}
				logger.info(custName + " Your Total Bill is "
						+ customerHasOrderDish.get(index).getOrder().getBillOfCustomer());
			}
		}

		else {
			logger.info("Order First");
		}
	}*/

	/*public static void whichProductCustomerWantToDelete() {
		customer = new Customer(custName);
		index = customerHasOrderDish.indexOf(customer);
		if (index != -1) {
			logger.info("Enter The Id Of The Food You Want To Delete");
			logger.info(() -> String.format(Constant.FORMAT_LITERAL, "FoodId", Constant.FOODNAME, Constant.FOODPRICE));
			// Here we get food that has been order by each customer
			foods = customerHasOrderDish.get(index).getOrder().getFoods();
			for (Food f : foods) {
				logger.info(
						() -> String.format(Constant.FORMAT_LITERAL, f.getFoodId(), f.getFoodName(), f.getFoodPrice()));

			}
			// Id of The Food That user want To delete
			Integer foodIdYouWantToDelete = scanner.nextInt();
			scanner.nextLine();
			// Here we get quantity of each food That we want to remove before remove from
			// list
			Integer inventoryQtyBeforeDelete = foodList.get(foodIdYouWantToDelete - 1).getQty();
			// After removing The product by customer it get added in the inventory again
			foodList.get(foodIdYouWantToDelete - 1).setQty(inventoryQtyBeforeDelete + 1);
			// When customer removes the product from his order then total bill will get
			// updated again
			customerHasOrderDish.get(index).getOrder()
					.setBillOfCustomer(customerHasOrderDish.get(index).getOrder().getBillOfCustomer()
							- foods.get(foodIdYouWantToDelete - 1).getFoodPrice());
			// Here actual product get remove from order of customer
			foods.removeIf(food -> food.getFoodId().equals(foodIdYouWantToDelete));
			// after modifying the order list set the order list
			customerHasOrderDish.get(index).getOrder().setFoods(foods);
		} else {
			System.out.println("You should Order first");
		}

	}*/

	/*public static void customerLogout() {
		custName = "";
		custPass = "";
		logger.info("LogOut Successfully");
	}*/

}
