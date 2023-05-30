package com.dgv.restaurant.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRANAV_DESAI_SPRING_FOOD")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="food_id")
	private Integer foodId;
	@Column(name="food_quantity")
	private Integer foodQuantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;
	
	public void addOrder(Order order,Inventory inventory)
	{
		this.order=order;
		this.inventory=inventory;
		order.addFood(this);
		inventory.addFoodToTheInventory(this);
	}
	public Food(Integer foodQuantity)
	{
		this.foodQuantity=foodQuantity;
	}
	
}
