package com.example.caprstome_SpringBoot.service;

import java.util.List;

import com.example.caprstome_SpringBoot.payload.CustomerDto;

public interface CustomerService {
	
	CustomerDto  createAccount(CustomerDto customerDto);
    CustomerDto getCustomerById(long id);
    CustomerDto updateCustomer(CustomerDto customerDto, long id);
    List<CustomerDto> getAllCustomers();

}
