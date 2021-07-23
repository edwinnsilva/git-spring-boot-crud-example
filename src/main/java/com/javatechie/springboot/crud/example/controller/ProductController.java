package com.javatechie.springboot.crud.example.controller;

import com.javatechie.springboot.crud.example.entity.Product;
import com.javatechie.springboot.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

 @Autowired
 private ProductService service;

 @PostMapping("/addProduct")
 public Product addProduct(@RequestBody Product product){
    return service.saveProduct(product);
 }

 @PostMapping("/addProducts")
 public List<Product> addProducts(@RequestBody List<Product> products) {
  return service.saveProducts(products);
 }

 @GetMapping("/products")
 public List<Product> findAllProducts(){
  return service.getProducts();
 }

 @GetMapping("/productById/{id}")
 public Product findProductById(@PathVariable int id){
  return service.getProductById(id);
 }

 @GetMapping("/productByName/{name}")
 public Product findProductByName(@PathVariable String name){
  return service.getProductByName(name);
 }

 @PutMapping("/update")
 public Product updateProduct(@RequestBody Product product){
  return service.updateProduct(product);
 }

 @DeleteMapping("/delete/{id}")
 public String deletProduct(@PathVariable int id){
  return service.deleteProduct(id);
 }

}
