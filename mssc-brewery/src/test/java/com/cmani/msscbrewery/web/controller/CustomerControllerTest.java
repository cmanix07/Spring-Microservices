package com.cmani.msscbrewery.web.controller;

import com.cmani.msscbrewery.web.model.CustomerDto;
import com.cmani.msscbrewery.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    public final String BASE_PATH = "/api/v1/customer/";
    @MockBean
    public CustomerService customerService;
    public static CustomerDto customer;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @BeforeAll
    public static void setUp() {
        customer = CustomerDto.builder().id(UUID.randomUUID()).customerName("chinta").build();
    }

    @Test
    void shouldGetCustomerById_Success() throws Exception {
        when(customerService.getCustomerById(Mockito.any())).thenReturn(customer);
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("chinta"));

    }

    @Test
    void shouldSaveCustomer_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(BASE_PATH,CustomerDto.class)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(customer)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void shouldUpdateCustomer_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(BASE_PATH+UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(customer)))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent()) ;
    }

    @Test
    void shouldDeleteCustomer_Success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(BASE_PATH+UUID.randomUUID()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());

    }
}