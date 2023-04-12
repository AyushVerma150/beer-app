package com.in28minutes.restwebapp.springmvcrestapi.controller;


import com.in28minutes.restwebapp.springmvcrestapi.model.Beer;
import com.in28minutes.restwebapp.springmvcrestapi.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;

    @GetMapping(path = "/beer/{id}")
    public Beer getBeerById(@PathVariable UUID id){
        log.debug( "In Controller - getBeerById" );
        return beerService.getBearById( id );
    }


    @PostMapping(path = "beer")
    public ResponseEntity createBeer(@RequestBody Beer beer){
        Beer savedBeer = beerService.create(beer);
        HttpHeaders headers = new HttpHeaders( );
        headers.add("Location" , "/api/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @GetMapping(path = "/beer")
    public List<Beer> allBeers(){
        return beerService.getAllBeers();

    }
}