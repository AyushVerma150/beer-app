package com.in28minutes.restwebapp.springmvcrestapi.controller;


import com.in28minutes.restwebapp.springmvcrestapi.exception.BeerNotFoundExceptionHandler;
import com.in28minutes.restwebapp.springmvcrestapi.model.Beer;
import com.in28minutes.restwebapp.springmvcrestapi.services.BeerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@RestController
public class BeerController {
    private final BeerService beerService;


//    @ExceptionHandler(BeerNotFoundExceptionHandler.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ErrorDetail handleNoSuchElementFoundException(BeerNotFoundExceptionHandler ex , HttpServletRequest request) {
//        return new ErrorDetail(404, ex.getMessage() , LocalDateTime.now(), request.getRequestURI());
//    }


    @GetMapping(path = "/beer/{id}")
    public Beer getBeerById(@PathVariable UUID id) throws BeerNotFoundExceptionHandler {
       Beer exists =  beerService.getBearById(id);
       if(exists == null) throw new BeerNotFoundExceptionHandler( id + " No such beer found with the given ID.");
       return exists;
    }


    @PostMapping(path = "beer")
    public ResponseEntity createBeer(@Valid @RequestBody Beer beer){
        Beer savedBeer = beerService.create(beer);
        HttpHeaders headers = new HttpHeaders( );
        headers.add("Location" , "/api/v1/beer/" + savedBeer.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @GetMapping(path = "/beer")
    public List<Beer> allBeers(){
        return beerService.getAllBeers();
    }

    @PutMapping("/beer/{id}")
    public ResponseEntity updateBeerById(@PathVariable UUID id , @RequestBody Beer beer){
        beerService.updateBeerById(id,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/beer/{id}")
    public ResponseEntity deleteBeerById(@PathVariable UUID id){
        beerService.removeBeerById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}