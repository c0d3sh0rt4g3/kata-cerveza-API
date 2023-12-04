package com.example.katacerveza.exceptions;


public class BeerNotFoundException extends RuntimeException {
    public BeerNotFoundException(Integer id) {
        super("Beer not found with id " + id);
    }
}
