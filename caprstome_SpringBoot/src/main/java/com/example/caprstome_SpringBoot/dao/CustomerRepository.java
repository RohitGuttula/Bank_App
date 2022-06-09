package com.example.caprstome_SpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.caprstome_SpringBoot.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
