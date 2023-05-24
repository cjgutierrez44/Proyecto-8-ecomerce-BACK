package com.tig.ecomerce.service;

import com.tig.ecomerce.model.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart getShoppingCartByUserId(int id);
	ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
}
