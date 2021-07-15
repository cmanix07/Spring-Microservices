package com.cmani.msscbrewery.web.controller;

import com.cmani.msscbrewery.web.model.BeerDto;
import com.cmani.msscbrewery.service.BeerService;
import com.cmani.msscbrewery.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Junit testing using SpringBoot and junit5


@WebMvcTest(BeerController.class)
public class BeerControllerTest {

    private BeerDto validBeerDto;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    public BeerService beerService;
    @MockBean
    public CustomerService customerService;
    @Autowired
    public ObjectMapper mapper;



    @BeforeEach
    public void setup() {
        validBeerDto = BeerDto.builder()
                .id(UUID.fromString(UUID.randomUUID().toString()))
                .beerName("Test beer")
                .beerStyle("Test Style")
                .upc(1l).build();
    }

    @Test
    public void shouldGetBeer_Success() throws Exception {
        when(beerService.getBeerById(Mockito.any(UUID.class))).thenReturn(validBeerDto);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"+ validBeerDto.getId().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(validBeerDto.getId().toString()));
    }

    @Test
    public void shouldSaveNewBeer_Success() throws Exception {
        BeerDto beerDto = validBeerDto;
        beerDto.setId(null);
        BeerDto savedBeerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();

        String beerDtoJson = mapper.writeValueAsString(beerDto);

        when(beerService.saveBeer(Mockito.any())).thenReturn(savedBeerDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                //       .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateBeerById_success() throws Exception {
        System.out.println("shouldUpdateBeerById_success: "+validBeerDto);

        BeerDto beerDto = validBeerDto;
        beerDto.setId(null);
        String beerDtoJson = mapper.writeValueAsString(beerDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteBeerById_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/beer/"+UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}
