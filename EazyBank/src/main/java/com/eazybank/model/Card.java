package com.eazybank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Card {
	@Id
	@GeneratedValue
	private long customerId;
	private String cardName;
	private String cardNumber;
	private String cardType;
}
