package com.isi.l3gl.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isi.l3gl.core.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}