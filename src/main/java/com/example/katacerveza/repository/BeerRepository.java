package com.example.katacerveza.repository;

import com.example.katacerveza.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Integer> {
    boolean existsByName(String name);
}
