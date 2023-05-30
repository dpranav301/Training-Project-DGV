package com.dgv.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalBillDto {

	private Long customerId;
	private String customerName;
	private double totalBill;

}
