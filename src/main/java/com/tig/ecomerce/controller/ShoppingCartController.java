package com.tig.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.ShoppingCart;
import com.tig.ecomerce.model.ShoppingCartProduct;
import com.tig.ecomerce.service.ShoppingCartProductService;
import com.tig.ecomerce.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingCarts")
@CrossOrigin(origins = "*")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	ShoppingCartProductService shoppingCartServiceProduct;
	
	
	
	@GetMapping("/byUserId/{id}")
	public ShoppingCart getShoppingCartByUserId(@PathVariable("id") int id){
		return shoppingCartService.getShoppingCartByUserId(id);
	}
	
	@PostMapping("/addProduct")
	public ShoppingCartProduct addProduct(@RequestParam("userId") int userId, @RequestParam("productId") int productId, @RequestParam("amount") int amount) {
		return shoppingCartServiceProduct.saveShoppingCartProduct(userId, productId, amount);
	}
	
	@GetMapping("/updateAmount/{id}/{amount}")
	public int updateAmount(@PathVariable("id") int id, @PathVariable("amount") int amount) {
		System.out.println(amount);
		return shoppingCartServiceProduct.updateAmount(id, amount);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		shoppingCartServiceProduct.deleteProduct(id);
	}

}
