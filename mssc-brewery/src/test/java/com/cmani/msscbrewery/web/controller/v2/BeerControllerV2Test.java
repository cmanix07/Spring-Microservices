package com.cmani.msscbrewery.web.controller.v2;

import com.cmani.msscbrewery.web.model.v2.BeerDtoV2;
import com.cmani.msscbrewery.web.model.v2.BeerStyleEnum;
import com.cmani.msscbrewery.service.v2.BeerServiceV2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerControllerV2.class)
public class BeerControllerV2Test {
    private static BeerDtoV2 validBeer;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BeerServiceV2 beerServiceV2;

    @BeforeAll
    public static void setup(){
        validBeer = BeerDtoV2.builder().
                id(UUID.randomUUID())
                .beerName("Asahi Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .upc(1l)
                .build();
    }

    @Test
    public void shouldGetBeerById_Success() throws Exception {
        when(beerServiceV2.getBeerById(any())).thenReturn(validBeer);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.beerName").value("Asahi Beer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.beerStyle").value("ALE"));
    }

}
