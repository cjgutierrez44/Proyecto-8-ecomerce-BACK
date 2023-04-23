package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.Category;
import com.tig.ecomerce.model.Product;

public interface ProductService {
	List<Product> getProducts(String keyWord);
	Product getProductById(int id);
	Product saveProduct(Product product);
	Product updateProduct(Product product);
	Product deleteProduct(int id);
	Product restoreProduct(int id);
	List<Product> getProductsByMinPrice(double minPrice);
	List<Product> getProductsByMaxPrice(double maxPrice);
	List<Product> getProductsByPriceBetween(double minPrice, double maxPrice);
	List<Product> getProductsByuserId(int state_id, int user_id);
}
