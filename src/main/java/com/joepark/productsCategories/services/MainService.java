package com.joepark.productsCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.joepark.productsCategories.models.Category;
import com.joepark.productsCategories.models.Product;
import com.joepark.productsCategories.repositories.CategoryRepository;
import com.joepark.productsCategories.repositories.ProductRepository;

@Service
public class MainService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public MainService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	// PRODUCT SERVICES
	public List<Product> findProducts() {
		return (List<Product>) productRepository.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProduct(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	// CATEGORY SERVICES
	public List<Category> findCategories() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category getCategory(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
	
	// JOIN
	public void join(Long prodId, Long catId) {
		Product product = this.productRepository.findById(prodId).orElse(null);
		Category category = this.categoryRepository.findById(catId).orElse(null);
		
		product.getCategories().add(category);
		
		this.productRepository.save(product);
	}
	
}
