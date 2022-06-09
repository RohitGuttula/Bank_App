package com.example.caprstome_SpringBoot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.caprstome_SpringBoot.dao.CustomerRepository;
import com.example.caprstome_SpringBoot.exception.ResourceNotFoundException;
import com.example.caprstome_SpringBoot.model.Customer;
import com.example.caprstome_SpringBoot.payload.CustomerDto;
import com.example.caprstome_SpringBoot.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
private CustomerRepository customerRepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public CustomerDto createAccount(CustomerDto customerDto) {
		//convert DTO to entity
		Customer customer=maptoEntity(customerDto);
		Customer newCustomer=customerRepository.save(customer);
		
		//convert entity to DTO
		CustomerDto customerResponse= maptoDto(newCustomer);
		return customerResponse;
	}

	
	@Override
	public CustomerDto getCustomerById(long id) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
		return maptoDto(customer);
	}
	
	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto, long id) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
		
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setEmail(customerDto.getEmail());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		customer.setAccountType(customerDto.getAccountType());
		customer.setAccountNumber(customerDto.getAccountNumber());
		customer.setBankBalance(customerDto.getBankBalance());
		Customer updatedCustomer=customerRepository.save(customer);
		return maptoDto(updatedCustomer);
	}
	
	//converted Entity into DTO
	private CustomerDto maptoDto(Customer customer) {
		CustomerDto customerDto=new CustomerDto();
		customerDto.setId(customer.getAccount_id());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setPhoneNumber(customer.getPhoneNumber());
		customerDto.setAccountType(customer.getAccountType());
		customerDto.setAccountNumber(customer.getAccountNumber());
		customerDto.setBankBalance(customer.getBankBalance());
		return customerDto;
	}
	//converted DTO to Entity
	private Customer maptoEntity(CustomerDto customerDto) {
		Customer customer=new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setEmail(customerDto.getEmail());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		customer.setAccountType(customerDto.getAccountType());
		customer.setAccountNumber(customerDto.getAccountNumber());
		customer.setBankBalance(customerDto.getBankBalance());
		return customer;	
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers=customerRepository.findAll();
		return customers.stream().map(customer -> maptoDto(customer)).collect(Collectors.toList());
	}


}
