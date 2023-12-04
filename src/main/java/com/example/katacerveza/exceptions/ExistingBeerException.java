package com.example.katacerveza.exceptions;

public class ExistingBeerException extends RuntimeException{
    public ExistingBeerException(String beerName){super("Beer with name " + beerName + " already exists");}
}
