package com.dgv.restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FoodDto {

	private Integer inventorysId;
	private String foodName;
	private Integer foodQty;
	//private Integer foodId;

}
