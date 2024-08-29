package com.belajarspring.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.belajarspring.model.entitites.Category;

public interface CategoryRepo extends CrudRepository<Category, Long> {

    
} 
