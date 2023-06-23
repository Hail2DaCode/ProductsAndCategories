package com.brian.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.products.models.Category;
import com.brian.products.models.Product;
import com.brian.products.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	public List<Product> allProducts() {
		return productRepo.findAll();
	}
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}
	}
	public void addCategory (Product product, Category category) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		productRepo.save(product);
	}
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	public List<Product> productsNotInCategory(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
}
