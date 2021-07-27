package com.javatechie.springboot.crud.example.dto;

import com.javatechie.springboot.crud.example.entity.CategoriaEnum;
import lombok.Data;


@Data
public class ProductDto {
        private int id;
        private String name;
        private int quantity;
        private Boolean isNew;
        private double price;
        private String comentarios;
        private CategoriaEnum categoria ; //Nuevo, Usado, Regalado, Encontrado

}
