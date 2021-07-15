package com.cmani.msscbreweryrestdocs.service.v2;

import com.cmani.msscbreweryrestdocs.web.model.v2.BeerDtoV2;
import com.cmani.msscbreweryrestdocs.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("King Fisher")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(100l)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beer) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("New Beer")
                .beerStyle(BeerStyleEnum.ROYAL)
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        log.debug("Beer has been updated corresponding to beerId: "+beerId.toString());
        //To update the beer corresponding to uuid.
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Beer has been deleted: "+beerId.toString());
        //deleteBeer from db.
    }
}
