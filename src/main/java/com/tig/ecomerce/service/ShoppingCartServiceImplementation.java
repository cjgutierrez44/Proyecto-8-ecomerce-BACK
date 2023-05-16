package com.tig.ecomerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.ShoppingCart;
import com.tig.ecomerce.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService{

	@Autowired
	ShoppingCartRepository repository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	StateService stateService;
	
	@Override
	public ShoppingCart getShoppingCartByUserId(int id) {
		Optional<ShoppingCart> shoppingCart = repository.findByUserId(id);
		if(shoppingCart.isPresent()) {
			return shoppingCart.get();
		}else{
			ShoppingCart s = new ShoppingCart(userService.getUserbyId(id), stateService.getStateById(3));
			return repository.save(s);
		}
	}

	@Override
	public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
		return repository.save(shoppingCart);
	}

	@Override
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return null;
	}

}
