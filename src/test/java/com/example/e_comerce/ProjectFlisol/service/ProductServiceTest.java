package com.example.e_comerce.ProjectFlisol.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.e_comerce.ProjectFlisol.model.Product;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService service;

    @Test
    void testSaveProduct(){
        Product p = new Product(null, "Test", 100);
        Product saved = service.save(p);
        assertNotNull(saved.getId());
    };
}