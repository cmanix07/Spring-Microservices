package com.cmani.msscbrewery.web.mapper;

import com.cmani.msscbrewery.domain.Customer;
import com.cmani.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    public Customer CustomerDtoToCustomer(CustomerDto customerDto);
    public CustomerDto CustomerToCustomerDto(Customer customer);
}
