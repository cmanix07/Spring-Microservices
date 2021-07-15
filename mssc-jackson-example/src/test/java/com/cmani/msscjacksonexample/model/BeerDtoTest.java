package com.cmani.msscjacksonexample.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
public class BeerDtoTest extends BeerBaseTest{
    @Test
    public void testSerializeDto() throws JsonProcessingException {
        BeerDto dto = getBeerDto();
        String jsonString = objectMapper.writeValueAsString(dto);
        System.out.println(jsonString);
    }
    @Test
    public void testDeserializeDto() throws JsonProcessingException {
        String jsonString = "{\"beerName\":\"New Beer Test\",\"beerStyle\":\"Mango mist style\",\"upc\":123123123,\"price\":\"189.75\",\"createdDate\":\"2020-11-22T09:59:00+0900\",\"lastModifiedDate\":\"2020-11-22T09:59:00.010463+09:00\",\"myLocalDate\":\"20201122\",\"beerId\":\"cda11382-292a-4752-862e-a017c13a0cb0\"}\n";
        BeerDto dto = objectMapper.readValue(jsonString, BeerDto.class);
        System.out.println(dto);
    }

}
