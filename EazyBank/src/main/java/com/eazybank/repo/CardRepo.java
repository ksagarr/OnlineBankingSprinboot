package com.eazybank.repo;

import org.springframework.data.repository.CrudRepository;

import com.eazybank.model.Card;

public interface CardRepo extends CrudRepository<Card, Long> {

	Card findByCustomerId(long customerId);
}
