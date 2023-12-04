package com.example.katacerveza.controller;

import com.example.katacerveza.exceptions.BeerNotFoundException;
import com.example.katacerveza.exceptions.ExistingBeerException;
import com.example.katacerveza.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.katacerveza.repository.BeerRepository;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class BeerController {
    @Autowired
    private final BeerRepository beerRepository;

    public BeerController(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @GetMapping("/beers")
    public List<Beer> allBeers(){
        return beerRepository.findAll();
    }
    @GetMapping("/beer/{id}")
    Beer getBeerById(@PathVariable Integer id)
    {
        return beerRepository.findById(id).orElseThrow(() -> new BeerNotFoundException(id));
    }
    @DeleteMapping("/beer/{id}")
    public ResponseEntity<?> deleteBeer(@PathVariable Integer id) {
        return beerRepository.findById(id)
                .map(beer -> {
                    beerRepository.delete(beer);
                    return ResponseEntity.status(HttpStatus.OK).body(beer.getName() + " deleted succesfully");
                })
                .orElseThrow(() -> new BeerNotFoundException(id));
    }
    @PostMapping("/beer")
    public ResponseEntity<Beer> postBeer(@RequestBody Beer givenBeer) {
        if (beerRepository.existsByName(givenBeer.getName())) {
            throw new ExistingBeerException(givenBeer.getName());
        }
        Beer newBeer = new Beer();
        setBeer(givenBeer, newBeer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBeer);
    }
    @PutMapping("/beer/{id}")
    public Beer updateBeer(@PathVariable Integer id, @RequestBody Beer givenBeer) {
        return beerRepository.findById(id)
                .map(existingBeer -> {
                    existingBeer.setId(givenBeer.getId());
                    setBeer(givenBeer, existingBeer);
                    return ResponseEntity.status(HttpStatus.OK).body(beerRepository.save(existingBeer)).getBody();
                })
                .orElseThrow(() ->  new BeerNotFoundException(id));
    }

    private void setBeer(@RequestBody Beer givenBeer, Beer beerToSet) {
        beerToSet.setBreweryId(givenBeer.getBreweryId());
        beerToSet.setName(givenBeer.getName());
        beerToSet.setCatId(givenBeer.getCatId());
        beerToSet.setStyleId(givenBeer.getStyleId());
        beerToSet.setAbv(givenBeer.getAbv());
        beerToSet.setIbu(givenBeer.getIbu());
        beerToSet.setSrm(givenBeer.getSrm());
        beerToSet.setUpc(givenBeer.getUpc());
        beerToSet.setFilePath(givenBeer.getFilePath());
        beerToSet.setDescription(givenBeer.getDescription());
        beerToSet.setAddUser(givenBeer.getAddUser());
        beerToSet.setLastMod(givenBeer.getLastMod());
    }
}