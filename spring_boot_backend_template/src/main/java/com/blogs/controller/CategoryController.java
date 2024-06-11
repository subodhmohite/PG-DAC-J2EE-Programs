package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;
import com.blogs.service.CategoryService;
/*
 * @Controller
 */
@RestController
@RequestMapping("/categories")//optional But recom
public class CategoryController {
	//dependency
	@Autowired
	private CategoryService categoryService;
	public CategoryController() {
		System.out.println("in contr of "+getClass());
		
	}
	/*
	 * 1. Get All Categories Design and Point of REST API URL-
	 * http://port/categories Method: GET Payload(request data)-NONE
	 * Resp-:@RequestBody List<category>
	 */
	@GetMapping
	public List<Category> listAllcategories(){
		System.out.println("in all categories");
		return categoryService.getAllCategories();
	}
	
	/*
	 * 2. Add new Category Design and Point of REST API for adding new
	 * Category(create) URL- http://port/categories Method: POST Payload(request
	 * data)-category details(name and description):Category entity
	 * JSON--> Java(de-ser| un marshalling)=> un marshalling
	 * Resp-:@RequestBody---Category (with generated id) (sent from
	 * RestController-->D.S --->marshalling (ser:Jar --> JSON)--> will be sent to
	 * the REST Client
	 */
	@PostMapping
	public Category addNewCategory(@RequestBody Category category) {
		System.out.println("in add new Category"+category);
		return categoryService.addNewCategory(category);
		
	}
	
	
	@DeleteMapping("/{categoryId}")
	//@PathVariable -method arrg level annotation to bind incomimg path 
	//method path var to the method arg 
	public ApiResponse deleteCategoryDetails(@PathVariable Long categoryId) {
		System.out.println("in delete category"+categoryId);
		
		return new ApiResponse(categoryService.deleteCategoryDetails(categoryId));
		
	}


	@GetMapping("/{catId}")
	public Category getCategoryDetails(@PathVariable Long catId) {
		System.out.println("in getCategoryDetails by "+catId);
		return categoryService.getcategoryDetails(catId);
	}
	
	@PutMapping
	public Category updateCategoryDetails(@RequestBody Category category) {
		System.out.println("in update"+category);
		return categoryService.updateCategoryDetails(category);
	}
	
	
	


}
