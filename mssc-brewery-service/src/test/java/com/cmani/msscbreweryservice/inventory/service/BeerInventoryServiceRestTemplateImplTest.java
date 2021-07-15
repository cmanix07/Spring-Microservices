package com.cmani.msscbreweryservice.inventory.service;

import com.cmani.msscbreweryservice.bootstrap.BeerLoader;
import com.cmani.msscbreweryservice.service.inventory.BeerInventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@Disabled //For unit test
@SpringBootTest
public class BeerInventoryServiceRestTemplateImplTest {
    @Autowired
    private BeerInventoryService beerInventoryService;
    
    @Test
    void getOnHandInventoryTest(){
        int qoh = beerInventoryService.getOnHandInventory(BeerLoader.BEER_1_UUID);
        System.out.println("Quantity on hand: "+qoh);
    }
}
