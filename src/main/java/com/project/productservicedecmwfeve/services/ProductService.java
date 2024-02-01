package com.project.productservicedecmwfeve.services;

import com.project.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.project.productservicedecmwfeve.models.Product;
import org.springframework.http.ResponseEntity;
import com.project.productservicedecmwfeve.exceptions.ProductNotExistException;
import java.util.List;

public interface ProductService {


    ResponseEntity<Product> getSingleProduct(Long id) throws ProductNotExistException;;

    Product deleteProduct(Long id);

    Product addnewProduct(FakeStoreProductDto productDto);

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);
}
