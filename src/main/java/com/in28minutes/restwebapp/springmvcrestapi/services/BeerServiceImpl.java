package com.in28minutes.restwebapp.springmvcrestapi.services;

import com.in28minutes.restwebapp.springmvcrestapi.model.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;


@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final Map<UUID,Beer> beerMap;

    public BeerServiceImpl(){
        this.beerMap = new HashMap<>();
        Beer beer1 = Beer.builder()
                .id( UUID.randomUUID() )
                .beerName("Galaxy Cat")
                .upc( "123456" )
                .version( 1 )
                .quantityOnHand( 122 )
                .price( new BigDecimal("12.99") )
                .createdDate( LocalDateTime.now() )
                .updatedDate( LocalDateTime.now() )
                .build( );

        Beer beer2 = Beer.builder()
                .id( UUID.randomUUID() )
                .beerName("Altroz")
                .upc( "123456" )
                .version( 1 )
                .quantityOnHand( 120 )
                .price( new BigDecimal("9.99") )
                .createdDate( LocalDateTime.now() )
                .updatedDate( LocalDateTime.now() )
                .build( );

        Beer beer3 = Beer.builder()
                .id( UUID.randomUUID() )
                .beerName("Corona")
                .upc( "123456" )
                .version( 1 )
                .quantityOnHand( 125 )
                .price( new BigDecimal("14.99") )
                .createdDate( LocalDateTime.now() )
                .updatedDate( LocalDateTime.now() )
                .build( );

        beerMap.put( beer1.getId() , beer1);
        beerMap.put( beer2.getId() , beer2);
        beerMap.put( beer3.getId() , beer3);


    }

    @Override
    public Beer getBearById(UUID id) {
        return beerMap.get( id );
    }

    @Override
    public List<Beer> getAllBeers() {
       return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer create(Beer beer) {
        try{
            beer.setId(UUID.randomUUID());
            beerMap.put(beer.getId(), beer);
            return beer;
        }
        catch( Exception err ){
           return null;
        }
    }
}