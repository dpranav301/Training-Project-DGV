package com.dgv.restaurant.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PRANAV_DESAI_SPRING_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "Bill")
	private Double bill;
	@Column(name = "status")
	private Boolean status;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private List<Food> food;

	// This is Use add bill and status of partcular order
	public Order(Double bill, Boolean status) {
		super();
		this.bill = bill;
		this.status = status;
		food = new ArrayList<>();
	}

	// This is Use to add User of this partcular order
	public void addUser(User user) {
		this.user = user;
		user.addOrder(this);
	}

	// As one order has many food so we save this food in that list
	public void addFood(Food food) {
		this.food.add(food);
	}

}
