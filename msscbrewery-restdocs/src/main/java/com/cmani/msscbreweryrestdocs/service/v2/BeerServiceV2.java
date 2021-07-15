package com.cmani.msscbreweryrestdocs.service.v2;

import com.cmani.msscbreweryrestdocs.web.model.v2.BeerDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BeerServiceV2 {
    Object getBeerById(UUID beerId);

    BeerDtoV2 saveBeer(BeerDtoV2 beer);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeer(UUID beerId);
}
