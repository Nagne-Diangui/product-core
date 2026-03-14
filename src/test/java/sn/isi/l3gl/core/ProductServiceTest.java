package sn.isi.l3gl.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sn.isi.l3gl.core.models.Product;
import sn.isi.l3gl.core.services.ProductService;

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

    @Test
    void testUpdateQuantity() {
        // 1. Arrange
        Product product = new Product();
        product.setName("Smartphone");
        product.setDescription("iPhone 13");
        product.setPrice(999.0);
        product.setQuantity(20);
        Product savedProduct = productService.createProduct(product);

        // 2. Act
        Product updatedProduct = productService.updateQuantity(savedProduct.getId(), 15);

        // 3. Assert
        assertEquals(15, updatedProduct.getQuantity());
    }

    @Test
    void testCountLowStockProducts() {
        // 1. Arrange
        Product product1 = new Product();
        product1.setName("Headphones");
        product1.setDescription("Sony WH-1000XM4");
        product1.setPrice(350.0);
        product1.setQuantity(3);
        productService.createProduct(product1);

        Product product2 = new Product();
        product2.setName("Monitor");
        product2.setDescription("LG UltraFine 4K");
        product2.setPrice(700.0);
        product2.setQuantity(2);
        productService.createProduct(product2);

        // 2. Act
        long lowStockCount = productService.countLowStockProducts();

        // 3. Assert
        assertTrue(lowStockCount >= 2);
    }
}