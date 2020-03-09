package com.laowang.service.impl;

import com.laowang.dao.OrderDao;
import com.laowang.domain.Order;
import com.laowang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao orderDao;

  @Override
  public void createOrder(Order order) {
    orderDao.save(order);
  }
}
