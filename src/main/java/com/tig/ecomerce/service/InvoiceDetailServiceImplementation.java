package com.tig.ecomerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.InvoiceDetail;
import com.tig.ecomerce.repository.InvoiceDetailRepository;

@Service
public class InvoiceDetailServiceImplementation implements InvoiceDetailService{
	
	@Autowired
	InvoiceDetailRepository repository;
	
	@Override
	public List<InvoiceDetail> saveAllInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		return repository.saveAll(invoiceDetails);
	}

}
