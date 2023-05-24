package com.tig.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.PaymentMethod;
import com.tig.ecomerce.repository.PaymentMethodRepository;

@Service
public class PaymentMethodServiceImplementation implements PaymentMethodService{
	
	@Autowired
	private PaymentMethodRepository repository;
	
	@Override
	public List<PaymentMethod> getPaymentMethods() {
		return repository.findAll();
	}

	@Override
	public List<PaymentMethod> saveAllPaymentMethods(List<PaymentMethod> paymentMethods) {
		return repository.saveAll(paymentMethods);
	}

	@Override
	public PaymentMethod getPaymentMethodById(int id) {
		Optional<PaymentMethod> paymentMethod = repository.findById(id); 
		if(paymentMethod.isPresent()) {
			return paymentMethod.get();
		}throw new RuntimeException("PaymentMethdod doesn´t exist in database");
	}

}
