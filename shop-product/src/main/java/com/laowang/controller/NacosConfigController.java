package com.laowang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosConfigController {

  @Autowired
  private ConfigurableApplicationContext configurableApplicationContext;

  @Value("config.appName")
  private String appName;

  @RequestMapping("/test-config1")
  public String testConfig1() {
    System.out.println("/test-config1 进来啦!");
    final String property = configurableApplicationContext.getEnvironment()
        .getProperty("config.appName");
    System.out.println("fdafa: "+property);
    return property;
  }

  @RequestMapping("/test-config2")
  public String testConfig2() {
    System.out.println("/test-config2 进来啦!");
    return appName;
  }


}
