package com.example.caprstome_SpringBoot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.caprstome_SpringBoot.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
     List<Account> findByid(long accountId);
}
