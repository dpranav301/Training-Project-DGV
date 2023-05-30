package com.dgv.restaurant.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgv.restaurant.dtos.OrderDto;
import com.dgv.restaurant.model.Order;
import com.dgv.restaurant.repository.OrderRepository;
import com.dgv.restaurant.service.BillService;
import com.dgv.restaurant.service.OrderService;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/bill")
@Slf4j
public class BillController {

	@Autowired
	private BillService billService;
	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderService orderService;
//	@Autowired
//	private ModelMapper mapper;
//	
	@GetMapping("/billOfCustomer/{custId}")
	public List<Order> getBill(@PathVariable Integer custId) {
		List<Order> orderList = billService.getById(custId);
		
		return orderList;
	}

	@PostMapping("/billStatus/{orderId}")
	public ResponseEntity<?> billStatus(@PathVariable Integer orderId) {
		Boolean result = billService.billStatus(orderId);
		return new ResponseEntity<>("Paid Succesfully", HttpStatus.ACCEPTED);
	}
	@GetMapping("/totalBill/{custId}")
	public ResponseEntity<?> totalBill(@PathVariable String custId){
		List<Order> orderList=billService.getById(Integer.parseInt(custId));
		String responseString="";
		if(orderList==null)
		{
			 responseString = "Place Order First";
			 return ResponseEntity.status(HttpStatus.OK).body(responseString);
		}
		else
		{
		Double totalBill=0.0;
		for(Order o:orderList)
		{
			if(o.getStatus()==false)
			{
				totalBill+=o.getBill();
			}
		}
		responseString="Your bill is "+totalBill;
		return new ResponseEntity<>(responseString,HttpStatus.OK);
		}
	}
	
	@GetMapping("/orderDetails/{userId}")
	 public List<OrderDto> getOrdersByUserId(@PathVariable Integer userId) {
	        return orderService.getDetailsOfOrder(userId);
	    }
	
	
	

}
