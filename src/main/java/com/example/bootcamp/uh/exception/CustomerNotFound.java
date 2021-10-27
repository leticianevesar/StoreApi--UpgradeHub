package com.example.bootcamp.uh.exception;

    public class CustomerNotFound extends RuntimeException{
        public CustomerNotFound() {
            super("Customer not found.");
        }
        public CustomerNotFound(String message) {
            super(message);
        }
    }


