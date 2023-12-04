package com.example.katacerveza.repository;

import com.example.katacerveza.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreweryRepository extends JpaRepository<Brewery, Integer> {
}
