package com.eazybank.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eazybank.model.Trasaction;

public interface TrasactionRepo extends CrudRepository<Trasaction, Long> {
 
	List<Trasaction> findByAccountNumber(String accountNumber);
	
}
