package com.laowang.service;

import com.laowang.domain.Product;

public interface ProductService {

  /**
   * 根据商品id查询产品
   *
   * @param pid
   * @return
   */
  Product findById(Integer pid);
}
