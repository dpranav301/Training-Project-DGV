package com.dgv.restaurant.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.restaurant.dtos.FoodDto;
import com.dgv.restaurant.model.Food;
import com.dgv.restaurant.model.Inventory;
import com.dgv.restaurant.model.Order;
import com.dgv.restaurant.model.User;
import com.dgv.restaurant.repository.FoodRepository;
import com.dgv.restaurant.service.FoodService;
import com.dgv.restaurant.service.InventoryService;
import com.dgv.restaurant.service.OrderService;
import com.dgv.restaurant.service.UserService;
@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepo;
	@Autowired
	private OrderService orderService;

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private UserService userService;

	@Override
	public Boolean placeOrder(FoodDto orderDetails, Integer custId) {
		Inventory foodItem = inventoryService.getById(orderDetails.getInventorysId());
		if(foodItem.getFoodQuantity()<orderDetails.getFoodQty())
		{
			return false;
		}
		// To get bill of food
		double bill = foodItem.getFoodPrice() * (orderDetails.getFoodQty());
		// First we create pojo of order and then save into order table
		Order order = new Order(bill, false);
		// partcular order ka user
		User userOfThisOrder = userService.getById(custId);
		// To add this partcular user into this order
		order.addUser(userOfThisOrder);
		order = orderService.addToOrder(order);
		Food food = new Food(orderDetails.getFoodQty());
		food.addOrder(order, foodItem);
		//Method call to update inventory
		inventoryService.updateInventoryAfterOrder(orderDetails.getFoodQty(), orderDetails.getInventorysId());
		if (foodRepo.save(food) != null)
			return true;
		return false;
	}

}
