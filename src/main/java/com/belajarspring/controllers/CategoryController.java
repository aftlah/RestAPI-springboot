package com.belajarspring.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajarspring.dto.ResponseDTO;
import com.belajarspring.model.entitites.Category;
import com.belajarspring.services.CategoryService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseDTO<Category>> create(@Valid @RequestBody Category categoryData, Errors errors) {
        ResponseDTO<Category> responseDTO = new ResponseDTO<Category>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseDTO.getMessages().add(error.getDefaultMessage());
            }
            responseDTO.setStatus(false);
            responseDTO.setPayload(null);

            return ResponseEntity.badRequest().body(responseDTO);
        }

        Category category = modelMapper.map(categoryData, Category.class);

        responseDTO.setStatus(true);
        responseDTO.setPayload(categoryService.save(category));

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public Iterable<com.belajarspring.model.entitites.Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable("id") Long id) {
        return categoryService.findOne(id);
    }


    @PutMapping
    public ResponseEntity<ResponseDTO<Category>> update(@RequestBody Category categoryData, Errors errors) {
        ResponseDTO<Category> responseDTO = new ResponseDTO<Category>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseDTO.getMessages().add(error.getDefaultMessage());
            }
            responseDTO.setStatus(false);
            responseDTO.setPayload(null);

            return ResponseEntity.badRequest().body(responseDTO);
        }

        Category category = modelMapper.map(categoryData, Category.class);

        responseDTO.setStatus(true);
        responseDTO.setPayload(categoryService.save(category));

        return ResponseEntity.ok(responseDTO);
    }
}
