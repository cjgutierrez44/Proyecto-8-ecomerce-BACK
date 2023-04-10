package com.tig.ecomerce.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tig.ecomerce.model.Category;
import com.tig.ecomerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE %:keyword%")
    List<Product> findByKeyword(@Param("keyword") String keyword);
    
    @Query("SELECT p FROM Product p WHERE p.price <= ?1")
    List<Product> findByPriceLessThanOrEqual(Double price);
    
    @Query("SELECT p FROM Product p WHERE p.price >= ?1")
    List<Product> findByPriceGreaterThanOrEqual(Double price);
    
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
