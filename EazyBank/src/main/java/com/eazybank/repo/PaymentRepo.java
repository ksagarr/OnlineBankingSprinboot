package com.eazybank.repo;

import org.springframework.data.repository.CrudRepository;

import com.eazybank.model.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Long> {

	Payment findByAccountNumber(String accountNumber);
}
