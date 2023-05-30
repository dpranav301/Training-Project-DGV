package com.dgv.restaurant.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRANAV_DESAI_SPRING_INVENTORY")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventory_id")
	private Integer inventoryId;
	@Column(name = "food_name")
	private String foodName;
	@Column(name = "food_price")
	private Double foodPrice;
	@Column(name = "food_quantity")
	private Integer foodQuantity;
	@OneToMany(mappedBy = "inventory")
	@JsonIgnore
	private List<Food> food;

	public Inventory(String foodName, Double foodPrice, Integer foodQuantity) {
		super();
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
		food = new ArrayList<>();
	}

	// This method is USe to add food in the inventory
	public void addFoodToTheInventory(Food food) {
		this.food.add(food);
	}

}
