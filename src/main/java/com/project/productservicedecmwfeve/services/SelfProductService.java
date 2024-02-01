package com.project.productservicedecmwfeve.services;

import com.project.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.project.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.project.productservicedecmwfeve.models.Product;
import com.project.productservicedecmwfeve.repositories.CategoryRepository;
import com.project.productservicedecmwfeve.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("selfProductService")
//@Primary

public class SelfProductService implements ProductService{

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public ResponseEntity<Product> getSingleProduct(Long id) throws ProductNotExistException {
        return null;
    }


    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public Product addnewProduct(FakeStoreProductDto productDto) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
