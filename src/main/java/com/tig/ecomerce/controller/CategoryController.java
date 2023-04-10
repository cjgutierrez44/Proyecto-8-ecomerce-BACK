package com.tig.ecomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.Category;
import com.tig.ecomerce.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public List<Category> getCategories(){
		return categoryService.getCategories();
	}
}
