package com.tig.ecomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.Invoice;
import com.tig.ecomerce.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@PostMapping("/save")
	public Invoice save(@RequestBody Invoice invoice) {
		System.out.println(invoice);
		return invoiceService.saveInvoice(invoice);
	}
	@GetMapping("/getInvoicesByUserId/{id}")
	public List<Invoice> getInvoicesByUserId(@PathVariable("id") int id){
		return invoiceService.getInvoicesByUserId(id);
	}
	@GetMapping("/getInvoiceById/{id}")
	public Invoice getInvoicesById(@PathVariable("id") int id){
		return invoiceService.getInvoiceById(id);
	}
	@GetMapping("/payInvoice/{id}")
	public Invoice payInvoice(@PathVariable("id") int id){
		return invoiceService.payInvoice(id);
	}
	@GetMapping("/cancelInvoice/{id}")
	public Invoice cancelInvoice(@PathVariable("id") int id){
		return invoiceService.cancelInvoice(id);
	}
	
	
}
