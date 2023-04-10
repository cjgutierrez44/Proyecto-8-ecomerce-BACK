package com.tig.ecomerce.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.City;
import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.service.CategoryService;
import com.tig.ecomerce.service.ProductService;
import com.tig.ecomerce.service.StateService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private StateService stateService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<Product> getProducts(@RequestParam(name = "keyword") String keyword, @RequestParam(name = "minPrice") double minPrice, @RequestParam(name = "maxPrice") double maxPrice){
		
		if(minPrice > 0 && maxPrice == 0) {
			return productService.getProductsByMinPrice(minPrice);
		}
		
		if(minPrice == 0 && maxPrice > 0) {
			return productService.getProductsByMaxPrice(maxPrice);
		}
		
		if(minPrice > 0 && maxPrice > 0) {
			return productService.getProductsByPriceBetween(minPrice, maxPrice);
		}
		
		return productService.getProducts(keyword);
	}
	
	@GetMapping("/ByCategoryId/{id}")
	public Set<Product> getProductsByCategoryId(@PathVariable("id") int id) {
		return categoryService.getCategoryById(id).getProducts();
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		product.setState(stateService.getStateById(3));
		product.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
		return productService.saveProduct(product);
	}
	
	@GetMapping("byId/{id}")
	public Product getProductoById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
	
}
