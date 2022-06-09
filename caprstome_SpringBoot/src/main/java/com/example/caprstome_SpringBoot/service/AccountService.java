package com.example.caprstome_SpringBoot.service;

import java.util.List;

import com.example.caprstome_SpringBoot.payload.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(long accountid,AccountDto accountDto);
	
	List<AccountDto> getAccountByCustid(long accountId); 
	
	AccountDto makeTransaction(long senderaccountid,long receiveraccountid,AccountDto accountDto,int ammount);

	String getBalanceById(long id);

}
