package com.example.e_comerce.ProjectFlisol.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.e_comerce.ProjectFlisol.model.Product;
import com.example.e_comerce.ProjectFlisol.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product save(Product product){
        return repository.save(product);
    }
    public void delete(Long id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado con id" + id);
        }
        repository.deleteById(id);
    }
    public Product update(Long id, Product product){
    Product existing = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    existing.setName(product.getName());
    existing.setPrice(product.getPrice());

    return repository.save(existing);
}
}
