package com.cmani.msscbreweryclient.web.client;

import com.cmani.msscbreweryclient.model.BeerDto;
import com.cmani.msscbreweryclient.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    public void shouldGetBeerById_Success(){
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    public void shouldSaveNewBeer_Success() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("new beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    public void shouldUpdateBeer_Success() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("new beer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }

    @Test
    public void shouldDeleteBeer_Success() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    public void shouldGetCustomerById_Success(){
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    public void shouldSaveNewCustomer_Success(){
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("chinta").build();
        URI uri = client.saveCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    public void shouldUpdateCustomer_Success(){
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Chintamani").build();
    client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    public void shouldDeleteCustomer_Success(){
    client.deleteCustomer(UUID.randomUUID());
    }
}