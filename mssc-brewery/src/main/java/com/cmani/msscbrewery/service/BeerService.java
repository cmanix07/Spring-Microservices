package com.cmani.msscbrewery.service;

import com.cmani.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {

    public BeerDto getBeerById(UUID id);


    BeerDto saveBeer(BeerDto beer);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
