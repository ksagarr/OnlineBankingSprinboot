package com.eazybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybank.model.Customer;
import com.eazybank.service.Customerservice;

@RestController
@RequestMapping("/cu")
public class CustomerCuntroller {

	@Autowired
	private Customerservice customerservice;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<>(customerservice.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getCustomer(@RequestParam String name)
	{
		return new ResponseEntity<>(customerservice.getCustomer(name),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/user")
	public ResponseEntity<Customer> getUser(Authentication authentication)
	{
		return new ResponseEntity<>(customerservice.getUserDetailsAfterLogin(authentication),HttpStatus.OK);
	}
}
