package com.laowang.service;

import com.laowang.dao.ProductDao;
import com.laowang.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  @Override
  public Product findById(Integer pid) {
    return productDao.findById(pid).get();
  }
}
