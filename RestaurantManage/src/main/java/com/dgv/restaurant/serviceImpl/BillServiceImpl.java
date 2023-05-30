package com.dgv.restaurant.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgv.restaurant.dtos.ResponseDto;
import com.dgv.restaurant.dtos.TotalBillDto;
import com.dgv.restaurant.model.Order;
import com.dgv.restaurant.model.User;
import com.dgv.restaurant.repository.OrderRepository;
import com.dgv.restaurant.service.BillService;
import com.dgv.restaurant.service.UserService;
@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	private UserService userService;
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public List<Order> getById(Integer custId) {
		User user = userService.getById(custId);
		// This is use to fecth all the orders of the particular customer
		List<Order> orderList = orderRepo.findByUser(user);
		if (!orderList.isEmpty()) {
			orderList.get(0)
			.getFood().size();
//			orderList.get(0)
//			.getFood()
//			.get(0)
//			.getInventory()
//			.getFoodName();
			return orderList;

		}
		return null;
	}

	@Override
	public Boolean billStatus(Integer orderId) {
		Order order = orderRepo.findById(orderId).orElseThrow();
		order.setStatus(true);
		return true;
	}

	
	

	

	
	
}
