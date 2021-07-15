package com.cmani.msscjacksonexample.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BeerBaseTest{

    public void beerDtoKebabTest() throws JsonProcessingException {
        BeerDto dto =getBeerDto();
        String json = objectMapper.writeValueAsString(dto);
        System.out.println(json);
    }
}
