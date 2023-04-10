package com.tig.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.Category;
import com.tig.ecomerce.repository.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService{

	@Autowired
	private CategoryRepository repository;
	
	@Override
	public List<Category> getCategories() {
		return repository.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		return repository.save(category);
	}

	@Override
	public List<Category> saveAllCategories(List<Category> categories) {
		
		return repository.saveAll(categories);
	}

	@Override
	public Category getCategoryById(int id) {
		Optional<Category> category  = repository.findById(id);
		if(category.isPresent()) {
			return category.get();
		}throw new RuntimeException("yhis categosry does not excist in database");
	}

}
