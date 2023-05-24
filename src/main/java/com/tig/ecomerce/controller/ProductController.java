package com.tig.ecomerce.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import com.tig.ecomerce.model.City;
import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.service.CategoryService;
import com.tig.ecomerce.service.FileUploadService;
import com.tig.ecomerce.service.ProductService;
import com.tig.ecomerce.service.StateService;
import com.tig.ecomerce.service.UserService;

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
	@Autowired
	private UserService userService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private ResourceLoader resourceLoader;
	
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
	
	@GetMapping("ByUserId/{id}")
	public List<Product> getProductsByUserId(@PathVariable("id") int id){
		return productService.getProductsByuserId(1, id);
	}
	
	@GetMapping("ByUserIdDeleted/{id}")
	public List<Product> getDeletedProductsByUserId(@PathVariable("id") int id){
		return productService.getProductsByuserId(2, id);
	}
	
	@GetMapping("/ByCategoryId/{id}")
	public Set<Product> getProductsByCategoryId(@PathVariable("id") int id) {
		return categoryService.getCategoryById(id).getProducts();
	}
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		product.setState(stateService.getStateById(1));
		product.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
		product.setUser(userService.getUserbyId(product.getUser().getId()));
		return productService.saveProduct(product);
	}
	
	@PostMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		System.out.println(product);
		product.setState(stateService.getStateById(1));
		product.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
		product.setUser(userService.getUserbyId(product.getUser().getId()));
		return productService.updateProduct(product);
	}
	
	@GetMapping("/byId/{id}")
	public Product getProductoById(@PathVariable("id") int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/remove/{id}")
	public Product removeProduct(@PathVariable("id") int id) {
		return productService.deleteProduct(id);
	}
	
	@GetMapping("/restore/{id}")
	public Product restoreProduct(@PathVariable("id") int id) {
		return productService.restoreProduct(id);
	}
	
	
	  @PostMapping("/upload/{nameImg}")
	  public void handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable("nameImg") String nameImg) throws IOException {
	    fileUploadService.uploadFile(file.getInputStream(), nameImg);
	  }
	  
	  @GetMapping("/imagen/{nombreArchivo}")
	  public ResponseEntity<Resource> getImage(@PathVariable String nombreArchivo) {
	      Resource resource = resourceLoader.getResource("classpath:upload/" + nombreArchivo);
	      if (resource.exists()) {
	          return ResponseEntity.ok()
	                  .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                  .body(resource);
	      } else {
	          return ResponseEntity.notFound().build();
	      }
	  }
	
}
