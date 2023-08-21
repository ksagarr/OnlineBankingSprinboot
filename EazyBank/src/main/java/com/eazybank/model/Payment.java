package com.eazybank.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Payment {

	@Id
	@GeneratedValue
	private long paymentId;
	private String name;
	private BigDecimal payment;
	private String accountNumber;
	private String paymentDate;
	@OneToMany
	@JoinColumn(name = "paymentId")
	private List<Trasaction> trasaction;
	
	
}
