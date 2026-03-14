package com.isi.l3gl.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isi.l3gl.core.models.Product;
import com.isi.l3gl.core.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product updateQuantity(Long id, int newQuantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        product.setQuantity(newQuantity);
        return productRepository.save(product);
    }
}
