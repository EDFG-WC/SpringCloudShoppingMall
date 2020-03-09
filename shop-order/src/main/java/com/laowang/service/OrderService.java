package com.laowang.service;

import com.laowang.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;

public interface OrderService {

  void createOrder(Order order);
}
