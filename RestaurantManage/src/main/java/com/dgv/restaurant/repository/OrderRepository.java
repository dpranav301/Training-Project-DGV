package com.dgv.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dgv.restaurant.dtos.OrderDto;
import com.dgv.restaurant.dtos.ResponseDto;
import com.dgv.restaurant.model.Order;
import com.dgv.restaurant.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByUser(User user);
	
	 @Query(nativeQuery = true, value = "SELECT u.user_name, SUM(o.bill) AS total_bill FROM pranav_desai_spring_user u JOIN pranav_desai_spring_order o ON u.user_id = o.user_id GROUP BY u.user_id")
	  List<ResponseDto> totalBillOfCustomer();

	public List<Order> findByStatus(Boolean b);
	 

//	     @Query(value =  "SELECT foodQuantity, foodName" +
//	             " FROM pranav_desai_spring_order o " +
//	             " JOIN Fetch pranav_desai_spring_food f ON o.order_id = f.order_id " +
//	             " JOIN fetch pranav_desai_spring_inventory i ON f.inventory_id = i.inventory_id " +
//	             " WHERE o.user_id =?1")
//	     List<OrderDto> getOrdersByUserId(Integer userId);

//	List<OrderDto> findByUser(User userId);


}
 