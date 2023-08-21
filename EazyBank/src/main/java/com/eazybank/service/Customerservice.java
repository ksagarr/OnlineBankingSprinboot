package com.eazybank.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eazybank.model.Customer;
import com.eazybank.repo.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Customerservice {

	private final CustomerRepo customerRepo;
	private final PasswordEncoder encoder;

	public Customer addCustomer(Customer customer) {
		customer.setPwd(encoder.encode(customer.getPwd()));
		customer.setCreateAt(new Date(System.currentTimeMillis()).toString());
		customer.setFullname(customer.getFirstname() + " " + customer.getLastname());
		customer.setAccountCreateAt(new Date(System.currentTimeMillis()).toString());
		customer.setAccountNumber(generateaccountNumber());
		String cardno = customer.getCard().getCardNumber();
		customer.setAccountBranch(customer.getBranch());
		customer.setCardNo(cardno.replaceAll("\\d{4}", "$0 "));
		return customerRepo.save(customer);
	}

	public List<Customer> getCustomer(String name) {
		return customerRepo.findByName(name);
	}

	public Customer getUserDetailsAfterLogin(Authentication authentication) {
		List<Customer> customers = customerRepo.findByName(authentication.getName());
		if (customers.size() > 0) {
			return customers.get(0);
		} else {
			return null;
		}
	}
	

	public String generateaccountNumber() {
		String acNumber = "BE";
		Random value = new Random();

		// Generate two values to append to 'BE'
		int r1 = value.nextInt(10);
		int r2 = value.nextInt(10);
		acNumber += Integer.toString(r1) + Integer.toString(r2) + " ";

		int count = 0;
		int n = 0;
		for (int i = 0; i < 8; i++) {
			if (count == 4) {
				acNumber += " ";
				count = 0;
			} else
				n = value.nextInt(10);
			acNumber += Integer.toString(n);
			count++;

		}
		return acNumber;
	}

}
