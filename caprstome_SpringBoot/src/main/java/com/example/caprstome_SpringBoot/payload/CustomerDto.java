package com.example.caprstome_SpringBoot.payload;

import lombok.Data;

@Data
public class CustomerDto {
	
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String accountType;
	private String accountNumber;
	private String bankBalance;

}
