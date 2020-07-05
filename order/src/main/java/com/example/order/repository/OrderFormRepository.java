package com.example.order.repository;

import com.example.order.pojo.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderFormRepository extends JpaRepository<OrderForm, String>, JpaSpecificationExecutor<OrderForm> {
//    Order findById();
}
