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
import com.belajarspring.dto.SupplierDTO;
import com.belajarspring.model.entitites.Supplier;
import com.belajarspring.services.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ModelMapper modelMapper;

    // Create Supplier data
    @PostMapping
    public ResponseEntity<ResponseDTO<Supplier>> create(@Valid @RequestBody SupplierDTO supplierDTO, Errors errors) {
        ResponseDTO<Supplier> response = new ResponseDTO<Supplier>();


        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                response.getMessages().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);
            return ResponseEntity.badRequest().body(response);
        }

        // Tanpa Model Mapper
        // Supplier supplier = new Supplier();
        // supplier.setName(supplierDTO.getName());
        // supplier.setAddress(supplierDTO.getAddress());
        // supplier.setEmail(supplierDTO.getEmail());

        // // Dengan Model Mapper
        Supplier supplier = modelMapper.map(response, Supplier.class);

        System.out.println(supplier);
        

        response.setStatus(true);
        response.setPayload(supplierService.save(supplier));

        return ResponseEntity.ok(response);

    }

    @GetMapping
    public Iterable<Supplier> findAll() {
        return supplierService.findAll();
    }

    @GetMapping("/{id}")
    public Supplier findOne(@PathVariable("id") Long id) {
        return supplierService.findOne(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<Supplier>> update(@Valid @RequestBody SupplierDTO supplierDTO, Errors errors) {
        ResponseDTO<Supplier> response = new ResponseDTO<Supplier>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                response.getMessages().add(error.getDefaultMessage());
            }
            response.setStatus(false);
            response.setPayload(null);
            return ResponseEntity.badRequest().body(response);
        }

        // Tanpa Model Mapper
        // Supplier supplier = new Supplier();
        // supplier.setName(supplierDTO.getName());
        // supplier.setAddress(supplierDTO.getAddress());
        // supplier.setEmail(supplierDTO.getEmail());

        // Dengan Model Mapper
        Supplier supplier = modelMapper.map(response, Supplier.class);

        response.setStatus(true);
        response.setPayload(supplierService.save(supplier));

        return ResponseEntity.ok(response);

    }

}
