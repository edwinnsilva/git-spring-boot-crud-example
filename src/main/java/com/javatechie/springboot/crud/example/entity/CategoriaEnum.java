package com.javatechie.springboot.crud.example.entity;

public enum CategoriaEnum {
    NUEVO ( "Nuevo"),
    USADO("Usado"),
    REGALADO("Regalado"),
    ENCONTRADO("Encontrado");

    private final String value;

    CategoriaEnum( String value) {
        this.value = value;
    }

    public String getNumVal() {
        return value;
    }
}
