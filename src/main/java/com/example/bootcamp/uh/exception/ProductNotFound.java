package com.example.bootcamp.uh.exception;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound() {
        super("Coffee not found.");
    }
    public ProductNotFound(String message) {
        super(message);
    }
}


