package com.eazybank.repo;

import org.springframework.data.repository.CrudRepository;

import com.eazybank.model.Balance;

public interface BalanceRepo extends CrudRepository<Balance, Long> {

	Balance findByCustomerId(long customerID);

}
