package com.cmani.msscbrewery.service;

import com.cmani.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDto getBeerById(UUID id) {

        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("King Fisher")
                .beerStyle("pale")
                .upc(100l)
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beer) {

        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("New Beer")
                .beerStyle("new taste")
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Beer has been updated corresponding to beerId: "+beerId.toString());
        //To update the beer corresponding to uuid.
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Beer has been deleted: "+beerId.toString());
        //deleteBeer from db.
    }


}
