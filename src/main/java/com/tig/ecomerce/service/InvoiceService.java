package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.Invoice;

public interface InvoiceService {
	List<Invoice> getInvoices();
	Invoice saveInvoice(Invoice invoice);
	Invoice getInvoiceById(int id);
	List<Invoice> getInvoicesByUserId(int id);
	Invoice payInvoice(int id);
	Invoice cancelInvoice(int id);
}
