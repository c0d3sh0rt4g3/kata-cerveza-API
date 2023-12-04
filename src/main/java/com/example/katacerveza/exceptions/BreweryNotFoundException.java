package com.example.katacerveza.exceptions;

public class BreweryNotFoundException extends RuntimeException{
    public BreweryNotFoundException(Integer id){super("Brewery not found with id " + id);}
}
