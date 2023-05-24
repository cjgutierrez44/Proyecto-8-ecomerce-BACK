package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.Category;
import com.tig.ecomerce.model.PaymentMethod;

public interface PaymentMethodService {
	List<PaymentMethod> getPaymentMethods();
	List<PaymentMethod> saveAllPaymentMethods(List<PaymentMethod> paymentMethods);
	PaymentMethod getPaymentMethodById(int id);
}
