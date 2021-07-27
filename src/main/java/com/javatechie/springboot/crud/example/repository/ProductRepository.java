package com.javatechie.springboot.crud.example.repository;

import com.javatechie.springboot.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
     Product findByname(String name);
}