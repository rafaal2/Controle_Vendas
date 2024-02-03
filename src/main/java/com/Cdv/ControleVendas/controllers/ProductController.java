package com.Cdv.ControleVendas.controllers;

import com.Cdv.ControleVendas.model.Product;
import com.Cdv.ControleVendas.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Product")
public class ProductController {

        @Autowired
        private ProductServices service;
        ///private PersonVoServices service = new PersonVoServices();

        @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public List<Product> findAll() {
            return service.findAll();
        }

        @GetMapping(value = "/{code}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public Product findById(@PathVariable(value = "code") Long code) {
            return service.finById(code);
        }	@PostMapping(
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public Product create(@RequestBody Product PersonVo) {
            return service.create(PersonVo);
        }

        @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
        public Product update(@RequestBody Product PersonVo) {
            return service.update(PersonVo);
        }


        @DeleteMapping(value = "/{code}")
        public ResponseEntity<?> delete(@PathVariable(value = "code") Long code) {
            service.delete(code);
            return ResponseEntity.noContent().build();
        }
}
