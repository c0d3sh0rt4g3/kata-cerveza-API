package com.example.katacerveza.controller;

import com.example.katacerveza.exceptions.NotFoundException;
import com.example.katacerveza.model.Style;
import com.example.katacerveza.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class StyleController {
    private StyleRepository styleRepository;
    @Autowired
    public StyleController(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }
    @GetMapping("/styles")
    public List<Style> getAllStyles(){
        return styleRepository.findAll();
    }
    @GetMapping("/style/{id}")
    public Style getStyleById(@PathVariable Integer id){
        return styleRepository.findById(id).orElseThrow(() -> new NotFoundException("Style", id));
    }
}
