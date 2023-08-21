package com.eazybank.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybank.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Long> {

	List<Customer> findByName(String name);
}
