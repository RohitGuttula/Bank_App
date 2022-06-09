package com.example.caprstome_SpringBoot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
@Data
@Entity
@Table(
		name="customers", uniqueConstraints={@UniqueConstraint(columnNames= {"accountNumber"})}
		)
public class Customer {
	@Id
	@GeneratedValue(
			strategy=GenerationType.IDENTITY
	)
		private Long account_id;
		@Column(name="firstName", nullable=false)
		private String firstName;
		@Column(name="lastName", nullable=false)
		private String lastName;
		@Column(name="email", nullable=false)
		private String email;
		@Column(name="phoneNumber", nullable=false)
		private String phoneNumber;
		@Column(name="accountType", nullable=false)
		private String accountType;
		@Column(name="accountNumber", nullable=false)
		private String accountNumber;
		@Column(name="bankBalance", nullable=false)
		private String bankBalance;
}
