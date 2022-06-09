package com.example.caprstome_SpringBoot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.caprstome_SpringBoot.dao.AccountRepository;
import com.example.caprstome_SpringBoot.dao.CustomerRepository;
import com.example.caprstome_SpringBoot.exception.ResourceNotFoundException;
import com.example.caprstome_SpringBoot.model.Account;
import com.example.caprstome_SpringBoot.model.Customer;
import com.example.caprstome_SpringBoot.payload.AccountDto;
import com.example.caprstome_SpringBoot.service.AccountService;
@Service
public class AccountServiceimpl implements AccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRespository;
    
	public AccountServiceimpl(AccountRepository accountRepository, CustomerRepository customerRespository) {
		//super();
		this.accountRepository = accountRepository;
		this.customerRespository = customerRespository;
	}
	@Override
	public AccountDto createAccount(long accountid, AccountDto accountDto) {
		Account account=mapToEntity(accountDto);
		Customer customer=customerRespository.findById(accountid).orElseThrow(
                            ()->new ResourceNotFoundException("Customer","id",accountid));
		account.setCustomer(customer);
		Account newAccount=accountRepository.save(account);
		return mapToDto(newAccount);
	}
	private AccountDto mapToDto(Account account) {
		AccountDto accountDto=new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setStatus(account.getStatus());
		return accountDto;
	}
	private Account mapToEntity(AccountDto accountDto) {
		Account account=new Account();
		account.setId(accountDto.getId());
		account.setBalance(accountDto.getBalance());
		account.setStatus(accountDto.getStatus());
		return account;
	}
	@Override
	public AccountDto makeTransaction(long senderaccountid, long receiveraccountid, AccountDto accountDto,
			int ammount) {
		Account customer=accountRepository.findById(senderaccountid).orElseThrow(
                ()->new ResourceNotFoundException("Account","id",senderaccountid));
		Account customer1=accountRepository.findById(receiveraccountid).orElseThrow(
                ()->new ResourceNotFoundException("Account","id",receiveraccountid));
		int send=Integer.parseInt(accountDto.getBalance());
		System.out.println(send);
		int receive=Integer.parseInt(accountDto.getBalance());
	if((send)>ammount) {
		send=send-ammount;
		System.out.println("send"+send);
		receive=receive+ammount;
		System.out.println("receive"+receive);
	}
	customer.setBalance(String.valueOf(send));
   customer.setBalance(String.valueOf(send));
	customer.setId(senderaccountid);
	customer.setStatus("Sent");
	customer1.setBalance(String.valueOf(receive));
	customer1.setId(receiveraccountid);
	customer1.setStatus("Received");
	Account account=accountRepository.save(customer);
    account=accountRepository.save(customer1);
	return mapToDto(account);
	
	}
		
	@Override
	public List<AccountDto> getAccountByCustid(long accountId) {
		List<Account> accounts=accountRepository.findByid(accountId);
		// TODO Auto-generated method stub
		return accounts.stream().map(account -> mapToDto(account)).collect(Collectors.toList());
	}
	@Override
	public String getBalanceById(long id) {
		Account customer=accountRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","id",id));
		return customer.getBalance();
	}
	

}
