package com.cmani.msscbreweryrestdocs.service;

import com.cmani.msscbreweryrestdocs.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {

        return CustomerDto.builder()
                .id(customerId)
                .customerName("Prasad Chintamani")
                .emailId("cmani.123@gmail.com")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customer) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .customerName(customer.getCustomerName())
                .emailId(customer.getEmailId())
                .build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customer) {
        //Actual logic should be updated
        log.debug("Customer is updated: customerId: "+id);
    }

    @Override
    public void deleteCustomer(UUID id) {
        //Actual delete logic should be updated
        log.debug("Customer has been deleted: "+id);
    }


}
