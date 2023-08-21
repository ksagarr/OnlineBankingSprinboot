package com.eazybank.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Balance {
    @Id
    @GeneratedValue
	private long customerId;
	private BigDecimal balance;
}
