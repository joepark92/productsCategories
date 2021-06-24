package com.joepark.productsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joepark.productsCategories.models.Category;
import com.joepark.productsCategories.models.Product;
import com.joepark.productsCategories.services.MainService;

@Controller
public class MainController {
	
	private final MainService mainService;
	
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/products/new";
	}
	
	// PRODUCT
	@GetMapping("/products/new")
	public String index(Model model, @ModelAttribute("product") Product product) {
		List<Product> allProducts = this.mainService.findProducts();
		model.addAttribute("allProducts", allProducts);
		return "AddProduct.jsp";
	}
	
	@PostMapping("/addProduct")
	public String create(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			List<Product> allProducts = this.mainService.findProducts();
			model.addAttribute("allProducts", allProducts);
			return "AddProduct.jsp";
		} else {
			Product newProd = mainService.addProduct(product);
			return "redirect:/products/" + newProd.getId();
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.mainService.getProduct(id);
		model.addAttribute("product", product);
		
		List<Product> allProducts = this.mainService.findProducts();
		model.addAttribute("allProducts", allProducts);
		
		List<Category> allCategories = this.mainService.findCategories();
		model.addAttribute("allCategories", allCategories);
		return "product.jsp";
	}
	
	// SELECTING A CATEGORY TO ADD TO THE PRODUCT
	@PostMapping("/joinCategory/{id}")
	public String join(@PathVariable("id") Long prodId, @RequestParam("selectCategory") Long catId) {
		this.mainService.join(prodId, catId);
		return "redirect:/products/{id}";
	}
	
	// CATEGORY
	@GetMapping("/categories/new")
	public String category(Model model, @ModelAttribute("category") Category category) {
		List<Category> allCategories = this.mainService.findCategories();
		model.addAttribute("allCategories", allCategories);
		return "AddCategory.jsp";
	}
	
	@PostMapping("/addCategory")
	public String createCategory(Model model, @Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			List<Category> allCategories = this.mainService.findCategories();
			model.addAttribute("allCategories", allCategories);
			return "AddCategory.jsp";
		}
		else {
			Category newCat = mainService.addCategory(category);
			return "redirect:/categories/" + newCat.getId();
		}
	}
	
	@GetMapping("/categories/{id}")
	public String categoryShow(@PathVariable("id") Long id, Model model) {
		Category category = this.mainService.getCategory(id);
		model.addAttribute("category", category);
		
		List<Category> allCategories = this.mainService.findCategories();
		model.addAttribute("allCategories", allCategories);
		
		List<Product> allProducts = this.mainService.findProducts();
		model.addAttribute("allProducts", allProducts);
		return "category.jsp";
	}
	
	// SELECTING A PRODUCT TO ADD TO THE CATEGORY
	@PostMapping("/joinProduct/{id}")
	public String joinCat(@PathVariable("id") Long catId, @RequestParam("selectProduct") Long prodId) {
		this.mainService.join(prodId, catId);
		return "redirect:/categories/{id}";
	}
}
