package com.cmani.msscbreweryrestdocs.web.mapper;

import com.cmani.msscbreweryrestdocs.domain.Beer;
import com.cmani.msscbreweryrestdocs.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    public BeerDto beerToBeerDto(Beer beer);

    public Beer beerDtoToBeer(BeerDto beerDto);
}
