package com.example.order.repository;

import com.example.order.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {
//    Order findById();
}
