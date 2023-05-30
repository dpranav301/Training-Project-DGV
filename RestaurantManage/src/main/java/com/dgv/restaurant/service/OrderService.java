package com.dgv.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgv.restaurant.dtos.OrderDto;
import com.dgv.restaurant.model.Order;

public interface OrderService {

	public Order addToOrder(Order order);
	
	public List<OrderDto> getDetailsOfOrder(Integer custId);

}
