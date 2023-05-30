package com.dgv.restaurant.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.restaurant.dtos.OrderDto;
import com.dgv.restaurant.model.Inventory;
import com.dgv.restaurant.model.Order;
import com.dgv.restaurant.repository.FoodRepository;
import com.dgv.restaurant.repository.InventoryRepo;
import com.dgv.restaurant.repository.OrderRepository;
import com.dgv.restaurant.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private InventoryRepo inventoryRepo;
	@Autowired
	private FoodRepository foodRepo;

	@Override
	public Order addToOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public List<OrderDto> getDetailsOfOrder(Integer custId) {

//		List<OrderDto> result=orderRepo.getOrdersByUserId(custId);
//		return result;
		return null;
	}


	

}
