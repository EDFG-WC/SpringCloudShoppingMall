package com.laowang.service;

import com.laowang.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// value的值 + requestMapping的路径就是ribbon的发送请求的路径: "http://service-product/product/" + pid
@FeignClient(value = "service-product")
public interface ProductService {

  @RequestMapping("/product/{pid}")
  Product findByPid(@PathVariable("pid") Integer pid);
}
