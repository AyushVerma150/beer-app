package com.in28minutes.restwebapp.springmvcrestapi.services;

import com.in28minutes.restwebapp.springmvcrestapi.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    Beer getBearById(UUID id);
    List<Beer> getAllBeers();
    Beer create(Beer beer);
}