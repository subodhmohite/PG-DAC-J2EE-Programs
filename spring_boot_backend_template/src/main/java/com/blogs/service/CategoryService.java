package com.blogs.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.blogs.entities.Category;

public interface CategoryService {
	public List<Category> getAllCategories();
	
	public Category addNewCategory(Category category);
	
	String deleteCategoryDetails(@PathVariable Long categoryId);
	
	Category getcategoryDetails(Long categoryId); 
	
	Category updateCategoryDetails(Category category);
	

}
