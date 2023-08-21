package com.eazybank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Account {
    
	@Id
	@GeneratedValue
	private long customerId;
	private String accountNumber;
	private String accountType;
	private String branch;
	private String createAt;
}
