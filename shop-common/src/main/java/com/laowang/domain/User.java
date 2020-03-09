package com.laowang.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity(name = "shop_user") // 实体类对数据表的对应
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //数据库自增
  private Integer uid;
  private String username;
  private String password;
  private String cellphoneNo;
}
