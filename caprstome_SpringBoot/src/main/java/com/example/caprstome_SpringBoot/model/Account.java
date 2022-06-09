package com.example.caprstome_SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(
		name="accounts", uniqueConstraints={@UniqueConstraint(columnNames= {"customer_id"})}
		)
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="balance", nullable=false)
	private String balance;
	@Column(name="status", nullable=false)
	private String status;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id", referencedColumnName="account_id")
	private Customer customer;
	
	

}
