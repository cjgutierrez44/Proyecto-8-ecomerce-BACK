package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.ShoppingCart;
import com.tig.ecomerce.model.ShoppingCartProduct;


public interface ShoppingCartProductService {
	List<ShoppingCartProduct> getShoppingCartProductsByShoppingCartId(int id);
	ShoppingCartProduct saveShoppingCartProduct(int userId, int productId, int amount);
	int updateAmount(int id, int amount);
	void deleteProduct(int id);
	
}
