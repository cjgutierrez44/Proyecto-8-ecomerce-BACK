package com.tig.ecomerce.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.City;
import com.tig.ecomerce.model.Comment;
import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.service.CommentService;
import com.tig.ecomerce.service.ProductService;

@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "*")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ProductService productService;
	
	
	
	@PostMapping("/save/{id}")
	public Comment saveComment(@RequestBody Comment comment, @PathVariable("id") int id) {
		
		
		Product p = productService.getProductById(id);
		comment.setProduct(p);
		return commentService.saveComment(comment);
	}
	
	@GetMapping("/byProductId/{id}")
	public Set<Comment> getCicomentsByProdcutId(@PathVariable("id") int id) {
		return productService.getProductById(id).getComments();
	}
	
}
