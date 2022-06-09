package com.example.caprstome_SpringBoot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.caprstome_SpringBoot.payload.CustomerDto;
import com.example.caprstome_SpringBoot.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<CustomerDto> createAccount(@RequestBody CustomerDto customerDto){
		return new ResponseEntity<>(customerService.createAccount(customerDto),HttpStatus.CREATED);
	}
	@GetMapping
	public List<CustomerDto> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name="id") long id){
		return ResponseEntity.ok(customerService.getCustomerById(id));	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable(name="id") long id){
		CustomerDto customerResponse=customerService.updateCustomer(customerDto, id);
		return new ResponseEntity<>(customerResponse,HttpStatus.OK);
	}
	
	

}
