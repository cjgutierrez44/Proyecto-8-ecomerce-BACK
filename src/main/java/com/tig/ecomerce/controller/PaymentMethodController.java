package com.tig.ecomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.PaymentMethod;
import com.tig.ecomerce.service.PaymentMethodService;

@RestController
@RequestMapping("/paymentMethods")
@CrossOrigin(origins = "*")
public class PaymentMethodController {
	
	@Autowired
	PaymentMethodService paymentMethodService;
	
	@GetMapping("")
	public List<PaymentMethod> getPaymentsMethods() {
		return paymentMethodService.getPaymentMethods();
	}
	
}
