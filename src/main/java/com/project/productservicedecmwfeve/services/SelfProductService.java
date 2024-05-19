package com.project.productservicedecmwfeve.services;

import com.project.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.project.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.project.productservicedecmwfeve.models.Category;
import com.project.productservicedecmwfeve.models.Product;
import com.project.productservicedecmwfeve.repositories.CategoryRepository;
import com.project.productservicedecmwfeve.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


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

        Optional<Product> optional = productRepository.findById(id);
        if(optional.isEmpty()) throw new ProductNotExistException("The product is not vailable");
        return new ResponseEntity<>(optional.get(),HttpStatus.OK);
    }


    @Override
    public void deleteProduct(Long id) {
       Optional<Product> optional = productRepository.findById(id);
        if(optional.isPresent())  productRepository.deleteById(id);
        return;
    }

    @Override
    public Product addnewProduct(Product product) {
        Category category = product.getCategory();
        if(!categoryRepository.existsById(category.getId()))
            categoryRepository.save(category);

        //if(!productRepository.existsById(product.getId()))

       return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

        if(productRepository.existsById(id)) return productRepository.save(product);
        else return null;
    }
}
