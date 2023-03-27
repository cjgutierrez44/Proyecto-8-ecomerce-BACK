package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.Product;

public interface ProductService {
	List<Product> getProducts();
	Product getProductById(int id);
	Product saveProduct(Product product);
	Product updateProduct(Product product);
	Product deleteProduct(int id);
}
