package com.example.katacerveza.controller;

import com.example.katacerveza.exceptions.BreweryNotFoundException;
import com.example.katacerveza.model.Brewery;
import com.example.katacerveza.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class BreweryController {
    private final BreweryRepository breweryRepository;
    @Autowired
    public BreweryController(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }
    @GetMapping("/breweries")
    public List<Brewery> getAllBreweries(){
        return breweryRepository.findAll();
    }
    @GetMapping("/brewerie/{id}")
    public Brewery getBreweryById(@PathVariable Integer id){
        return breweryRepository.findById(id).orElseThrow(() -> new BreweryNotFoundException(id));
    }
}
