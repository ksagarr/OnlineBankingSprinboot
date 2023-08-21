package com.eazybank.repo;

import org.springframework.data.repository.CrudRepository;

import com.eazybank.model.Account;

public interface AccountRepo extends CrudRepository<Account, Long> {

	Account findByCustomerId(long customerID);
}
