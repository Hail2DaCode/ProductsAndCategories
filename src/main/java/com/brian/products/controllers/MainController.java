package com.brian.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brian.products.models.Category;
import com.brian.products.models.Product;
import com.brian.products.services.CategoryService;
import com.brian.products.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private ProductService pServ;
	@Autowired
	private CategoryService cServ;
	@GetMapping("/")
	public String home(Model model) {
		List<Product> products = pServ.allProducts();
		List<Category> categories = cServ.allCategories();
		model.addAttribute("categories",categories);
		model.addAttribute("products",products);
		return "home.jsp";
	}
	@GetMapping("/products/new")
	public String newProductPage(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/new/product")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		else {
			pServ.createProduct(product);
			return "redirect:/";
		}
	}
	@GetMapping("/categories/new")
	public String newCategoryPage(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	@PostMapping("/new/category")
	public String createCategory(@Valid @ModelAttribute("category") Category cat, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		else {
			cServ.createCategory(cat);
			return "redirect:/";
		}
	}
	@GetMapping("/products/{id}")
	public String productPage(@PathVariable("id") Long id, Model model) {
		Product product = pServ.findProduct(id);
		model.addAttribute("product", product);
		List<Category> categories = cServ.categoriesNotInProduct(product);
		model.addAttribute("categories", categories);
		return "productPage.jsp";
	}
	@GetMapping("/products/{id}/add")
	public String addProduct(@PathVariable("id") Long pId, @RequestParam("category") Long cId) {
		Product newProduct = pServ.findProduct(pId);
		Category newCategory = cServ.findCategory(cId);
		pServ.addCategory(newProduct, newCategory);
		return "redirect:/";
	}
	@GetMapping("/categories/{id}")
	public String categoryPage(@PathVariable("id") Long id, Model model) {
		Category category = cServ.findCategory(id);
		model.addAttribute("category", category);
		List<Product> products = pServ.productsNotInCategory(category);
		model.addAttribute("products", products);
		return "categoryPage.jsp";
	}
	@GetMapping("/categories/{id}/add")
	public String addCategory(@PathVariable("id") Long cId, @RequestParam("product") Long pId) {
		Product newProduct = pServ.findProduct(pId);
		Category newCategory = cServ.findCategory(cId);
		pServ.addCategory(newProduct, newCategory);
		return "redirect:/";
	}
	
}
