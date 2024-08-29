package com.belajarspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajarspring.model.entitites.Product;
import com.belajarspring.model.repository.ProductRepo;

import jakarta.transaction.Transactional;

// Service ini akan digunakan untuk menghandle logic bisnis dari aplikasi kita

@Service
@Transactional
public class ProductService {

    @Autowired // Dependency Injection
    private ProductRepo productRepo;

    // Method untuk create atau update data product
    public Product save(Product product) {
        return productRepo.save(product);
    }

    // Method untuk delete data product
    public void delete(Product product) {
        productRepo.delete(product);
    }

    // Method untuk mencari data product berdasarkan id
    public Product findById(Long id) {
        Optional<Product> product  = productRepo.findById(id);

        if(!product.isPresent()){
            return null;
        }

        return productRepo.findById(id).get();
    }

    // Method untuk menampilkan semua data product
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    // Methode untuk menghapus data berdasarkan id
    public void removeOne(Long id) {
        productRepo.deleteById(id);
    }

    // ini adalah custom function yang di buat di ProductRepo
    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }
}
