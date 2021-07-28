package com.javatechie.springboot.crud.example.controller;

import com.javatechie.springboot.crud.example.dto.ProductDto;
import com.javatechie.springboot.crud.example.entity.Product;
import com.javatechie.springboot.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.javatechie.springboot.crud.example.entity.ProductTransformer.mapProductDtoToProduct;

@RestController
public class ProductController {

 @Autowired
 private ProductService service;

 @PostMapping("/addProduct")
 public Product addProduct(@RequestBody ProductDto productDto) throws Exception {
    return service.saveProduct(mapProductDtoToProduct(productDto));
 }

 @PostMapping("/addProducts")
 public List<Product> addProducts(@RequestBody List<ProductDto> productsDto) throws Exception{
  List<Product> products = new ArrayList<>();
  for (ProductDto productDto : productsDto)
   products.add( mapProductDtoToProduct(productDto));
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
 public Product updateProduct(@RequestBody ProductDto productDto) throws Exception {
  Product product = mapProductDtoToProduct(productDto);
  product.setId(productDto.getId());
  return service.updateProduct(product);
 }

 @DeleteMapping("/delete/{id}")
 public String deletProduct(@PathVariable int id){
  return service.deleteProduct(id);
 }
}