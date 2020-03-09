package com.laowang.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity(name = "shop_order")
@Data
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long oid;
  private Integer uid;
  private String username;
  private Integer pid;
  private String pname;
  private Integer pprice;
  private Integer number;
}
