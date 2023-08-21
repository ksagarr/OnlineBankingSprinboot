package com.eazybank.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Trasaction {
    @Id
    @GeneratedValue
	private long paymentId;
	private BigDecimal credit;
	private BigDecimal debt;
	private String accountNumber;
	private String destaccountNumber;
	private String transactionDate;
}
