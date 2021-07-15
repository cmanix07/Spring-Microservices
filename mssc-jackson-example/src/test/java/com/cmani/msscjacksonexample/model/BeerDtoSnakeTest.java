package com.cmani.msscjacksonexample.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BeerBaseTest{

    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto dto = getBeerDto();
        String json = objectMapper.writeValueAsString(dto);
        System.out.println(json);
    }
}
