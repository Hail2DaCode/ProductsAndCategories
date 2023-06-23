package com.brian.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brian.products.models.Category;
import com.brian.products.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product>findAll();
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
}
