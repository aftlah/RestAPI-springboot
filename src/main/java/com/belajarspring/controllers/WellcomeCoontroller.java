package com.belajarspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wellcome") // request mapping untuk memberikan prefix pada url (ROUTE)
public class WellcomeCoontroller {

    @GetMapping // supaya fungsi wellcome saat diakses menggunakan method GET (Mucul)
    public String wellcome() {
        return "Wellcome to Spring Boot REST API";
    }
}
