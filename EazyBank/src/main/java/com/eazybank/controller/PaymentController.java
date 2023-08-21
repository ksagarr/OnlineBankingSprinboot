package com.eazybank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eazybank.model.Balance;
import com.eazybank.model.Payment;
import com.eazybank.model.Trasaction;
import com.eazybank.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/add")
	public ResponseEntity<String> addBalnce(@RequestParam String name, long id, @RequestBody Payment payment) {
		return new ResponseEntity<>(paymentService.addBalance(name, id, payment), HttpStatus.CREATED);
	}

	@PostMapping("/send")
	public ResponseEntity<String> sendMoney(@RequestParam String name ,long id, @RequestBody Payment payment)

	{
		return new ResponseEntity<>(paymentService.sendMoney(name,id, payment), HttpStatus.CREATED);

	}
	
    @GetMapping("/getts")
	public ResponseEntity<List<Trasaction>> getTrasaction(@RequestParam String srcaccountNumber) 
	{
      return new ResponseEntity<>(paymentService.getTrasaction(srcaccountNumber),HttpStatus.OK);
	}
    
    @GetMapping("/balance")
    public ResponseEntity<Balance>getBalance(long id)
    {
    	return new ResponseEntity<>(paymentService.getBalace(id),HttpStatus.OK);
    }
}
