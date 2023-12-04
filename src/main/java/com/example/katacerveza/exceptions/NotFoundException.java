package com.example.katacerveza.exceptions;


public class NotFoundException extends RuntimeException {
    public NotFoundException(String type, Integer id) {
        super(type + " not found with id " + id);
    }
}
