package com.dgv.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

//	private Integer orderId;
//	private Double bill;
//	private String status;
	private Integer foodQuantity;
	private String foodName;
//	public OrderDto(Integer foodQuantity, String foodName) {
//		super();
//		this.foodQuantity = foodQuantity;
//		this.foodName = foodName;
//	}
	
	
}
