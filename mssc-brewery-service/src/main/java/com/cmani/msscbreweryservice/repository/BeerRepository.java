package com.cmani.msscbreweryservice.repository;

import com.cmani.msscbreweryservice.domain.Beer;
import com.cmani.msscbreweryservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer,UUID> {
    
    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);
    
    Page<Beer> findAllByBeerName(String beerName, PageRequest pageRequest);
    
    Page<Beer> findAllByBeerStyle(String beerName, PageRequest pageRequest);
}
