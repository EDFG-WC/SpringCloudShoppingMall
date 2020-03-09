package com.laowang.controller;

import com.alibaba.fastjson.JSON;
import com.laowang.domain.Order;
import com.laowang.domain.Product;
import com.laowang.service.OrderService;
import com.laowang.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private OrderService orderService;

  @Autowired
  private ProductService productService;

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/order/prod/{pid}")
  public Order order(@PathVariable("pid") Integer pid) {
    log.info("接受到{}号商品的下单请求, 接下来调用商品微服务查询此商品信息", pid);
    // 调用商品微服务, 查询商品信息
    // 直接ribbon负载均衡了:
    Product product = productService.findByPid(pid);
    log.info("查询到{}号商品的信息, 内容是:{}", pid, JSON.toJSONString(product));
    Order order = new Order();
    order.setUid(1);
    order.setNumber(1);
    order.setUsername("测试用户");
    order.setPid(pid);
    order.setPname(product.getPname());
    order.setPprice(product.getPprice());

    orderService.createOrder(order);
    log.info("创建订单信息成功, 订单信息为{}", JSON.toJSONString(order));

    return order;
  }

//  @RequestMapping("/order/prod/{pid}")
//  public Order order(@PathVariable("pid") Integer pid) {
//    log.info("接受到{}号商品的下单请求, 接下来调用商品微服务查询此商品信息", pid);
//    // 调用商品微服务, 查询商品信息
//    // 直接ribbon负载均衡了:
//    Product product = restTemplate
//        .getForObject("http://service-product/product/" + pid,
//            Product.class);
//    log.info("查询到{}号商品的信息, 内容是:{}", pid, JSON.toJSONString(product));
//    Order order = new Order();
//    order.setUid(1);
//    order.setNumber(1);
//    order.setUsername("测试用户");
//    order.setPid(pid);
//    order.setPname(product.getPname());
//    order.setPprice(product.getPprice());
//
//    orderService.createOrder(order);
//    log.info("创建订单信息成功, 订单信息为{}", JSON.toJSONString(order));
//
//    return order;
//  }

//  @RequestMapping("/order/prod/{pid}")
//  public Order order(@PathVariable("pid") Integer pid) {
//    log.info("接受到{}号商品的下单请求, 接下来调用商品微服务查询此商品信息", pid);
//    // 调用商品微服务, 查询商品信息
//    // 通过discoveryClient对象来从注册中心请求对方服务, 这样product如果开多实例就可以负载均衡
//    List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//    // 随即选择
//    int index = new Random().nextInt(instances.size());
//    ServiceInstance instance = instances.get(index);
//    Product product = restTemplate
//        .getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + pid,
//            Product.class);
//    log.info("查询到{}号商品的信息, 内容是:{}", pid, JSON.toJSONString(product));
//    Order order = new Order();
//    order.setUid(1);
//    order.setNumber(1);
//    order.setUsername("测试用户");
//    order.setPid(pid);
//    order.setPname(product.getPname());
//    order.setPprice(product.getPprice());
//
//    orderService.createOrder(order);
//    log.info("创建订单信息成功, 订单信息为{}", JSON.toJSONString(order));
//
//    return order;
//  }

//  @RequestMapping("/order/prod/{pid}")
//  public Order order(@PathVariable("pid") Integer pid) {
//    log.info("接受到{}号商品的下单请求, 接下来调用商品微服务查询此商品信息", pid);
//    // 调用商品微服务, 查询商品信息
//    // 通过discoveryClient对象来从注册中心请求对方服务, 这样product如果开多实例就可以负载均衡
//    List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//    ServiceInstance instance = instances.get(0);
//    Product product = restTemplate
//        .getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + pid,
//            Product.class);
//    log.info("查询到{}号商品的信息, 内容是:{}", pid, JSON.toJSONString(product));
//    Order order = new Order();
//    order.setUid(1);
//    order.setNumber(1);
//    order.setUsername("测试用户");
//    order.setPid(pid);
//    order.setPname(product.getPname());
//    order.setPprice(product.getPprice());
//
//    orderService.createOrder(order);
//    log.info("创建订单信息成功, 订单信息为{}", JSON.toJSONString(order));
//
//    return order;
//  }

//  @RequestMapping("/order/prod/{pid}")
//  public Order order(@PathVariable("pid") Integer pid) {
//    log.info("接受到{}号商品的下单请求, 接下来调用商品微服务查询此商品信息", pid);
//    // 调用商品微服务, 查询商品信息
//    Product product = restTemplate
//        .getForObject("http://localhost:8081/product/" + pid, Product.class);
//    log.info("查询到{}号商品的信息, 内容是:{}", pid, JSON.toJSONString(product));
//    Order order = new Order();
//    order.setUid(1);
//    order.setNumber(1);
//    order.setUsername("测试用户");
//    order.setPid(pid);
//    order.setPname(product.getPname());
//    order.setPprice(product.getPprice());
//
//    orderService.createOrder(order);
//    log.info("创建订单信息成功, 订单信息为{}", JSON.toJSONString(order));
//
//    return order;
//  }
}
