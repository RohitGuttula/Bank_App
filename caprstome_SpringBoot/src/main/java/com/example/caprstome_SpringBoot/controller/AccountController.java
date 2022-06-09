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

import com.example.caprstome_SpringBoot.payload.AccountDto;
import com.example.caprstome_SpringBoot.payload.CustomerDto;
import com.example.caprstome_SpringBoot.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	@PostMapping("/customers/accounts")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto.getId(), accountDto),HttpStatus.CREATED);
	}
	@GetMapping("/customers/{accountId}/accounts")
	public List<AccountDto> getAccountsByCustid(@PathVariable(value="accountId") Long accountId){
		return accountService.getAccountByCustid(accountId);
	}
	@PutMapping("/customers/{accountId}/accounts/{ammount}")
	public ResponseEntity<AccountDto> makeTransaction(@PathVariable(value="accountId") Long accountId,
			                                         @RequestBody  AccountDto accountDto,
			                                          @PathVariable(value="ammount") int ammount ){
		AccountDto makeTransaction=accountService.makeTransaction(accountId, accountDto.getId(), accountDto, ammount);
		return new ResponseEntity<>(makeTransaction,HttpStatus.OK);
	}
	@GetMapping("/customer/{accountId}/accounts")
	public String getBalanceById(@PathVariable(name="accountId") long id){
		return (accountService.getBalanceById(id));	
	}
}
