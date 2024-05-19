package com.project.productservicedecmwfeve.controllers;

import com.project.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.project.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.project.productservicedecmwfeve.models.Product;
import com.project.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){

        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id) throws ProductNotExistException {
        return productService.getSingleProduct(id);
    }

    @PostMapping("/addProduct")
    public Product addNewProduct(@RequestBody @Validated Product product) {

        return productService.addnewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){

        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){

        return new Product();
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
