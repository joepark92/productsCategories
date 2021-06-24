package com.joepark.productsCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joepark.productsCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}