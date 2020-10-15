package com.cmani.customer.service;

import com.cmani.customer.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {

        return CustomerDto.builder()
                .id(customerId)
                .customerName("Prasad Chintamani")
                .emailId("cmani.123@gmail.com")
                .build();
    }
}
