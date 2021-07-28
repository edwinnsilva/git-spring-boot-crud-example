package com.javatechie.springboot.crud.example.entity;

import com.javatechie.springboot.crud.example.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PRODUCT_TBL")
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    private int status;
    private double price;
    private int categoria;

    public static Product mapProductDtoToProduct(ProductDto productDto) throws Exception {
        Product product = new Product();

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        if (productDto.getIsNew()){
            product.setStatus(1);
        }
        else{
            product.setStatus(0);
        }

        try{
            switch (productDto.getCategoria()) {
                case NUEVO:
                    product.setCategoria(1);
                    System.out.println("categoria nuevo");
                    break;
                case USADO:
                    product.setCategoria(2);
                    break;
                case REGALADO:
                    product.setCategoria(3);
                    break;
                case ENCONTRADO:
                    product.setCategoria(4);
                    break;
                default:
                    System.out.println("Error Categoria Incorrecta");
            }
        }
        catch (Exception e)  {
            throw new Exception("Error en la aplicacion");
        }

        return product;
    }

}