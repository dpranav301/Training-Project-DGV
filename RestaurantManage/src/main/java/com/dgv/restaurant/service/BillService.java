package com.dgv.restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dgv.restaurant.dtos.TotalBillDto;
import com.dgv.restaurant.model.Order;
@Service
public interface BillService {

	public List<Order> getById(Integer custId);

	public Boolean billStatus(Integer orderId);	

}
