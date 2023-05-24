package com.tig.ecomerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.Invoice;
import com.tig.ecomerce.model.InvoiceDetail;
import com.tig.ecomerce.model.PaymentMethod;
import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.model.ShoppingCart;
import com.tig.ecomerce.model.ShoppingCartProduct;
import com.tig.ecomerce.model.State;
import com.tig.ecomerce.model.User;
import com.tig.ecomerce.repository.InvoiceRepository;

@Service
public class InvoiceServiceImplementation implements InvoiceService{

	@Autowired
	private InvoiceRepository repository;
	
	@Autowired
	private UserService userService;
	@Autowired
	private PaymentMethodService paymentMethodService;
	@Autowired
	private StateService stateService;
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	@Autowired
	private ProductService productService;
	
	
	@Override
	public List<Invoice> getInvoices() {
		return repository.findAll();
	}

	@Override
	public Invoice saveInvoice(Invoice invoice) {
		
		User user = userService.getUserbyId(invoice.getUser().getId());
		PaymentMethod paymentMethod = paymentMethodService.getPaymentMethodById(invoice.getPaymentMethod().getId());
		State state = stateService.getStateById(5);
		invoice.setUser(user);
		invoice.setPeymentMethod(paymentMethod);
		invoice.setState(state);
		
		ShoppingCart shoppingcart = shoppingCartService.getShoppingCartByUserId(user.getId());
		
		shoppingcart.setState(stateService.getStateById(4));
		
		shoppingCartService.saveShoppingCart(shoppingcart);
		
		Double subTotal = 0.0;
		List<InvoiceDetail> detail = new ArrayList<>();
		for(ShoppingCartProduct shoppingCartProduct : shoppingcart.getShoppingCartProducts()) {
			System.out.println(shoppingCartProduct.getProduct().getName());
			subTotal += shoppingCartProduct.getProduct().getPrice() * shoppingCartProduct.getAmount();
		}
		
		invoice.setSubTotal(subTotal);
		invoice.setTotal(subTotal + (subTotal * 0.19));

		
		
		invoice = repository.save(invoice);
		
		
		for(ShoppingCartProduct shoppingCartProduct : shoppingcart.getShoppingCartProducts()) {
			Product p = shoppingCartProduct.getProduct();
			detail.add(new InvoiceDetail(invoice, p, shoppingCartProduct.getProduct().getPrice(), shoppingCartProduct.getAmount()));
			p.setQuantity(p.getQuantity() - shoppingCartProduct.getAmount());
			productService.updateProduct(p);
			
		}

		
		invoiceDetailService.saveAllInvoiceDetails(detail);
		return invoice;
	}

	@Override
	public List<Invoice> getInvoicesByUserId(int id) {
		return repository.getInvoicesByUserId(id);
	}

	@Override
	public Invoice getInvoiceById(int id) {
		Optional<Invoice> invoice = repository.findById(id);
		if(invoice.isPresent()) {
			return invoice.get();
		}throw new RuntimeException("Invoice doesn´t exist in database");
	}

	@Override
	public Invoice payInvoice(int id) {
		Optional<Invoice> invoice = repository.findById(id);
		if(invoice.isPresent()) {
			invoice.get().setState(stateService.getStateById(6));
			return repository.save(invoice.get());
		}throw new RuntimeException("Invoice doesn´t exist in database");
	}

	@Override
	public Invoice cancelInvoice(int id) {
		Optional<Invoice> invoice = repository.findById(id);
		if(invoice.isPresent()) {
			invoice.get().setState(stateService.getStateById(7));
			List<InvoiceDetail> detail = invoice.get().getDetail();
			for(InvoiceDetail det : detail) {
				Product p = det.getProduct();
				p.setQuantity(p.getQuantity() + det.getAmount());
				productService.updateProduct(p);
			}
			return repository.save(invoice.get());
		}throw new RuntimeException("Invoice doesn´t exist in database");
	}

}
