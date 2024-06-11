package com.blogs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.customexceptions.ResourceNotFoundException;
import com.blogs.entities.Category;
import com.blogs.repository.CategoryRepository;
@Service
@Transactional
public class CategoryServiceimpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		//new Category(null, null)
		return categoryRepository.findAll();
	}

	@Override
	public Category addNewCategory(Category newCategory) {
		//use the inherited method from CRUD repository 
		//public T save(T entity)
		return categoryRepository.save(newCategory);
	}

	@Override
	public String deleteCategoryDetails(Long catId) {
		if(categoryRepository.existsById(catId)) {
		categoryRepository.deleteById(catId);
		return "category details deleted";
	}
		return "deleting category details fail:Invalid category ID";
	}

	@Override
	public Category getcategoryDetails(Long categoryId) {
		// inherited method -Optional<Category> findById
		Optional<Category> optional=categoryRepository.findById(categoryId);
		return optional.orElseThrow(()->
				new ResourceNotFoundException("Invalid Category id"));
	}

	@Override
	public Category updateCategoryDetails(Category category) {
		

		return categoryRepository.save(category);
	}
}
