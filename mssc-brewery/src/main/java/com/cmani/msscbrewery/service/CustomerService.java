package com.cmani.msscbrewery.service;

import com.cmani.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {

    public CustomerDto getCustomerById(UUID id);

    CustomerDto saveCustomer(CustomerDto customer);

    void updateCustomer(UUID id, CustomerDto customer);

    void deleteCustomer(UUID id);
}
