package com.belajarspring.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belajarspring.model.entitites.Product;

public interface ProductRepo extends CrudRepository<Product, Long> { // <NamaEntiti, Type Primarykey>

    // Custom function untuk mencari data
    List<Product> findByNameContains(String name);
    
}
