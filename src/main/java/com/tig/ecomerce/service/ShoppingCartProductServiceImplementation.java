package com.tig.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.model.ShoppingCart;
import com.tig.ecomerce.model.ShoppingCartProduct;
import com.tig.ecomerce.repository.ShoppingCartProductRepository;

@Service
public class ShoppingCartProductServiceImplementation implements ShoppingCartProductService{
	
	@Autowired
	ShoppingCartProductRepository repository;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	ProductService productService;
	
	@Override
	public List<ShoppingCartProduct> getShoppingCartProductsByShoppingCartId(int id) {
		return repository.getShoppingCartProductsByShoppingCartId(id);
	}

	@Override
	public ShoppingCartProduct saveShoppingCartProduct(int userId, int productId, int amount) {
		ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUserId(userId);
		Product product = productService.getProductById(productId);
		Optional<ShoppingCartProduct> s = repository.getShoppingCartProductByPorductIdAndCart(productId, shoppingCart.getId());
		ShoppingCartProduct shoppingCartProduct;
		if(s.isPresent()) {
			shoppingCartProduct = s.get();
			amount += shoppingCartProduct.getAmount();
		}else {
			shoppingCartProduct = new ShoppingCartProduct(shoppingCart, product, amount);
		}
		if(product.getQuantity() < amount) {
			amount = product.getQuantity();	
		}
		shoppingCartProduct.setAmount(amount);
		return repository.save(shoppingCartProduct);
	}

	@Override
	public int updateAmount(int id, int amount) {
		Optional<ShoppingCartProduct> shoppingCartProduct = repository.findById(id);
		if(shoppingCartProduct.isPresent()) {
			ShoppingCartProduct s = shoppingCartProduct.get();
			if(s.getProduct().getQuantity() < amount) {
				amount = s.getProduct().getQuantity();	
			}
			s.setAmount(amount);
			repository.save(s);
			if(amount == 0) {
				repository.delete(s);
			}
			
			return amount;
		}throw new RuntimeException("ShoppingCartProduct doesn´t exist in database");
		
	}

	@Override
	public void deleteProduct(int id) {
		Optional<ShoppingCartProduct> shoppingCartProduct = repository.findById(id);
		if(shoppingCartProduct.isPresent()) {
			repository.delete(shoppingCartProduct.get());
		}
		
		
	}



}
