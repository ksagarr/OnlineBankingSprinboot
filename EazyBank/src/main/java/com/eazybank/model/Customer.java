package com.eazybank.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String name;
	private String pwd;
	private String firstname;
	private String lastname;
	private String fullname;
	private String email;
	private String mobile;
	private String city;
	private String state;
	private String pincode;
	private String country;
	private String branch;
	private String createAt;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Set<Role> role;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId",referencedColumnName = "customerId",insertable = false,updatable = false)
	private Account account;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId",referencedColumnName = "customerId",insertable = false,updatable = false,nullable = false)
	private Balance balance;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId",referencedColumnName = "customerId",insertable = false,updatable = false)
	private Card card;
	public void setAccountCreateAt(String createAt) {
		account.setCreateAt(createAt);
		
	}
	public void setCardNo(String cardno) {
		card.setCardNumber(cardno);
		
	}
	public void setAccountBranch(String branch) {
		account.setBranch(branch);
		
	}
	
	public void setAccountNumber(String acNumber) {
		account.setAccountNumber(acNumber);
	}

}
