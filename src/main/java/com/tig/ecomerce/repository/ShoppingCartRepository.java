package com.tig.ecomerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tig.ecomerce.model.ShoppingCart;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	@Query("SELECT s FROM ShoppingCart s WHERE s.user.id = ?1 AND s.state.id = 3")
	Optional<ShoppingCart>  findByUserId(int id);
}
