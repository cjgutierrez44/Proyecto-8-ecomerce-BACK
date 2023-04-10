package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.Category;

public interface CategoryService {
	List<Category> getCategories();
	Category saveCategory(Category category);
	List<Category> saveAllCategories(List<Category> categories);
	Category getCategoryById(int id);
}
