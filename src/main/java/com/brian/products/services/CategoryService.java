package com.brian.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.products.models.Category;
import com.brian.products.models.Product;
import com.brian.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository catRepo;
	public List<Category> allCategories() {
		return catRepo.findAll();
	}
	public Category findCategory(Long id) {
		Optional<Category> optionalCat = catRepo.findById(id);
		if (optionalCat.isPresent()) {
			return optionalCat.get();
		}
		else {
			return null;
		}
	}
	public void addProduct(Product product, Category category) {
		List<Product> products = category.getProducts();
		products.add(product);
		category.setProducts(products);
		catRepo.save(category);
	}
	public Category createCategory(Category cat) {
		return catRepo.save(cat);
	}
	public List<Category> categoriesNotInProduct(Product product) {
		return catRepo.findByProductsNotContains(product);
	}
}
