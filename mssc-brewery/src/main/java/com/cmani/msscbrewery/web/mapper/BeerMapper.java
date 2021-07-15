package com.cmani.msscbrewery.web.mapper;

import com.cmani.msscbrewery.domain.Beer;
import com.cmani.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    public BeerDto beerToBeerDto(Beer beer);

    public Beer beerDtoToBeer(BeerDto beerDto);
}
