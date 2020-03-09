package com.laowang.dao;


import com.laowang.domain.Product;
import com.laowang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
