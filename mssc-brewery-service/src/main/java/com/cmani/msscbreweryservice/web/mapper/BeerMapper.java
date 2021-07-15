package com.cmani.msscbreweryservice.web.mapper;

import com.cmani.msscbreweryservice.domain.Beer;
import com.cmani.msscbreweryservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    public BeerDto beerToBeerDto(Beer beer);
    
    public BeerDto beerToBeerDtoWithInventory(Beer beer);
    
    public Beer beerDtoToBeer(BeerDto beerDto);
}
