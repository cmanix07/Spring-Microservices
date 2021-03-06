package com.cmani.customer.service;

import com.cmani.customer.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {

    public CustomerDto getCustomerById(UUID id);
}
