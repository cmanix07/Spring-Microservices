package com.cmani.msscjacksonexample.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BeerBaseTest {
    @Autowired
    ObjectMapper objectMapper;
    
    BeerDto getBeerDto(){
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("New Beer Test")
                .beerStyle("Mango mist style")
                .price(new BigDecimal(189.75))
                .upc(123123123L)
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .myLocalDate(LocalDate.now())
                .build();
    }
}
