package com.dgv.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dgv.restaurant.model.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
