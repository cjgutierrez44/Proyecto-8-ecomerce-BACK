package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.InvoiceDetail;

public interface InvoiceDetailService {
	List<InvoiceDetail> saveAllInvoiceDetails(List<InvoiceDetail> invoiceDetails);
}
