package com.isi.l3gl.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isi.l3gl.core.models.Product;
import com.isi.l3gl.core.services.ProductService;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void testCreateProduct() {
        // 1. Arrange (Préparation des données)
        Product product = new Product();
        product.setName("Laptop");
        product.setDescription("Dell XPS 15");
        product.setPrice(1500.0);
        product.setQuantity(10);

        // 2. Act (Action)
        Product savedProduct = productService.createProduct(product);

        // 3. Assert (Vérification)
        assertNotNull(savedProduct.getId());
        assertEquals("Laptop", savedProduct.getName());
    }

    @Test
    void testListProducts() {

        var products = productService.listProducts();

        assertTrue(products.size() >= 3);
    }
}