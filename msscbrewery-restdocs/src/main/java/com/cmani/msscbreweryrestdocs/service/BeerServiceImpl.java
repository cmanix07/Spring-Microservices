package com.cmani.msscbreweryrestdocs.service;

import com.cmani.msscbreweryrestdocs.web.model.BeerDto;
import com.cmani.msscbreweryrestdocs.web.model.v2.BeerStyleEnum;
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
                .beerStyle(BeerStyleEnum.PALE)
                .upc(100l)
                .build();
    }

    @Override
    public BeerDto saveBeer(BeerDto beer) {

        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("New Beer")
                .beerStyle(BeerStyleEnum.ALE)
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
