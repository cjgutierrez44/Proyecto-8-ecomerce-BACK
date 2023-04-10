package com.tig.ecomerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.Category;
import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private StateService stateService;
	
	@Override
	public List<Product> getProducts(String keyWord) {
		if(keyWord != null) {
		  return repository.findByKeyword(keyWord);
		}
		return repository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> product = repository.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		throw new RuntimeException("Product doesn´t exist in database");
	}

	@Override
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> p = repository.findById(product.getId());
		if(p.isPresent()) {
			return repository.save(product);
		}
		throw new RuntimeException("Product doesn´t exist in database");
	}

	@Override
	public Product deleteProduct(int id) {
		Optional<Product> product = repository.findById(id);
		if(product.isPresent()) {
			product.get().setState(stateService.getStateById(2));
		}
		throw new RuntimeException("Product doesn´t exist in database");
	}

	@Override
	public List<Product> getProductsByMinPrice(double minPrice) {
		return repository.findByPriceGreaterThanOrEqual(minPrice);
	}

	@Override
	public List<Product> getProductsByMaxPrice(double maxPrice) {
		return repository.findByPriceLessThanOrEqual(maxPrice);
	}

	@Override
	public List<Product> getProductsByPriceBetween(double minPrice, double maxPrice) {
		return repository.findByPriceBetween(minPrice, maxPrice);
	}



}
