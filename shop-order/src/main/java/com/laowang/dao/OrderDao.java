package com.laowang.dao;


import com.laowang.domain.Order;
import com.laowang.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
