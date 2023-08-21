package com.eazybank.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eazybank.model.Balance;
import com.eazybank.model.Customer;
import com.eazybank.model.Payment;
import com.eazybank.model.Trasaction;
import com.eazybank.repo.BalanceRepo;
import com.eazybank.repo.CustomerRepo;
import com.eazybank.repo.PaymentRepo;
import com.eazybank.repo.TrasactionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	private final PaymentRepo paymentRepo;
	private final BalanceRepo balanceRepo;
	private final CustomerRepo customerRepo;
	private final TrasactionRepo trasactionRepo;
	
	public String addBalance(String name,long customerId,Payment payment)
	{
		List<Customer> customers=customerRepo.findByName(name);
		payment.setAccountNumber(customers.get(0).getAccount().getAccountNumber());
		Balance balance=balanceRepo.findByCustomerId(customerId);
		balance.setBalance(balance.getBalance().add(payment.getPayment()));
	    balanceRepo.save(balance);
	    payment.setPaymentDate(new Date(System.currentTimeMillis()).toString());
	    paymentRepo.save(payment);
	    Trasaction ts= new Trasaction();
		ts.setAccountNumber(customers.get(0).getAccount().getAccountNumber());
		ts.setCredit(payment.getPayment());
	    ts.setTransactionDate(new Date(System.currentTimeMillis()).toString());
	    trasactionRepo.save(ts);
		return payment.getPayment()+"has been credited in account";
	}
	
	public String sendMoney(String name,long customerId,Payment payment) {
		List<Customer> customers=customerRepo.findByName(name);
		Balance balance=balanceRepo.findByCustomerId(customerId);
		balance.setBalance(balance.getBalance().subtract(payment.getPayment()));
	    balanceRepo.save(balance);
	    payment.setPaymentDate(new Date(System.currentTimeMillis()).toString());
	    paymentRepo.save(payment);
	    Trasaction ts= new Trasaction();
	    ts.setAccountNumber(customers.get(0).getAccount().getAccountNumber());
		ts.setDestaccountNumber(payment.getAccountNumber());
		ts.setDebt(payment.getPayment());
	    ts.setTransactionDate(new Date(System.currentTimeMillis()).toString());
	    trasactionRepo.save(ts);
	    return payment.getPayment()+" Ammont Sucessfully send";
	}
	
	public List<Trasaction> getTrasaction(String accountNumber)
	{
		return trasactionRepo.findByAccountNumber(accountNumber);
	}
	
	public Balance getBalace(long customerID) {
		return balanceRepo.findByCustomerId(customerID);
	}
}
