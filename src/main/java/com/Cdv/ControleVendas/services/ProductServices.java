package com.Cdv.ControleVendas.services;


import com.Cdv.ControleVendas.exception.ResourceNotFoundException;
import com.Cdv.ControleVendas.model.Product;
import com.Cdv.ControleVendas.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class ProductServices {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(ProductServices.class.getName());
@Autowired
ProductRepository repository;
    public List<Product> findAll(){
        logger.info("finding all");
        return repository.findAll();
    }
    public Product finById(Long code) {
        logger.info("finding one product");
        var entity = repository.findById(code).orElseThrow(() -> new ResourceNotFoundException("nao achouu"));
        return entity;
    }

    public Product create (Product product){
        logger.info("creating one product");
        return repository.save(product);
    }
    public Product update(Product product){
        logger.info("creating one product");

        var entity = repository.findById(product.getCode())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setQuantity(product.getQuantity());
        entity.setTimestamp(new Date());
        return repository.save(entity);
    }
    public void delete(Long code) {

        logger.info("Deleting one Product!");

        var entity  = repository.findById(code).orElseThrow(() -> new ResourceNotFoundException("not found"));

        repository.delete(entity);
    }




}
