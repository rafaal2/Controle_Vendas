package com.Cdv.ControleVendas.repositories;

import com.Cdv.ControleVendas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
