package com.cmani.msscbreweryrestdocs.service;

import com.cmani.msscbreweryrestdocs.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerService {

    public BeerDto getBeerById(UUID id);


    BeerDto saveBeer(BeerDto beer);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeer(UUID beerId);
}
