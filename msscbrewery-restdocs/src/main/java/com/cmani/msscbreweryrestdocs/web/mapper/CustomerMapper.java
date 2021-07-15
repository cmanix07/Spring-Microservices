package com.cmani.msscbreweryrestdocs.web.mapper;


import com.cmani.msscbreweryrestdocs.domain.Customer;
import com.cmani.msscbreweryrestdocs.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    public Customer CustomerDtoToCustomer(CustomerDto customerDto);
    public CustomerDto CustomerToCustomerDto(Customer customer);
}
