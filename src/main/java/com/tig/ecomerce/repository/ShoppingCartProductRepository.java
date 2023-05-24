package com.tig.ecomerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tig.ecomerce.model.ShoppingCart;
import com.tig.ecomerce.model.ShoppingCartProduct;

public interface ShoppingCartProductRepository extends JpaRepository<ShoppingCartProduct, Integer>{
	@Query("SELECT s FROM ShoppingCartProduct s WHERE s.shoppingCart.id = ?1")
	List<ShoppingCartProduct> getShoppingCartProductsByShoppingCartId(int id);
	@Query("SELECT s FROM ShoppingCartProduct s WHERE s.product.id = ?1 AND s.shoppingCart.id = ?2")
	Optional<ShoppingCartProduct> getShoppingCartProductByPorductIdAndCart(int productId, int cartId);
}
