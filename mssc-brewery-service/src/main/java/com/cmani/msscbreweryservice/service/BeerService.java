package com.cmani.msscbreweryservice.service;

import com.cmani.msscbreweryservice.web.model.BeerDto;
import com.cmani.msscbreweryservice.web.model.BeerPagedList;
import com.cmani.msscbreweryservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    public BeerDto getBeerById(UUID beerId, Boolean showInventoryOnHand);
    
    BeerDto saveNewBeer(BeerDto beer);
    
    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);
    
    void deleteBeer(UUID beerId);
    
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
}
