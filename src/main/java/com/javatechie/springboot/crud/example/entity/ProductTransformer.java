package com.javatechie.springboot.crud.example.entity;

import com.javatechie.springboot.crud.example.dto.ProductDto;

public class ProductTransformer {
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
