package com.brian.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brian.products.models.Category;
import com.brian.products.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	public List<Category> findAll();
    // Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);

	
}
