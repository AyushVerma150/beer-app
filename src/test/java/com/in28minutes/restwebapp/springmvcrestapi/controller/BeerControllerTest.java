package com.in28minutes.restwebapp.springmvcrestapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
class BeerControllerTest {

    @Autowired
    BeerController beerController;

    @Test
    void getBeerById() throws Exception {
        System.out.println( beerController.getBeerById( UUID.randomUUID() ));
    }
}