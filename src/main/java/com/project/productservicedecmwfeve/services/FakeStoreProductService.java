package com.project.productservicedecmwfeve.services;

import com.project.productservicedecmwfeve.dtos.FakeStoreProductDto;
import com.project.productservicedecmwfeve.exceptions.ProductNotExistException;
import com.project.productservicedecmwfeve.models.Category;
import com.project.productservicedecmwfeve.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;


    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());;
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());

        return product;
    }

    @Override
    public ResponseEntity<Product>  getSingleProduct(Long id) throws ProductNotExistException{
       FakeStoreProductDto productDto =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if(productDto==null) {
            throw new ProductNotExistException("Product with id: "+id+ "does not exist");
        }
       ResponseEntity<Product> response = new ResponseEntity<>(convertFakeStoreProductToProduct(productDto), HttpStatus.OK);
        return response;
    }


    @Override
    public void deleteProduct(Long id){
        FakeStoreProductDto productDto =  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return;
    }

    @Override
    public Product addnewProduct(Product product){
        return new Product();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] response =  restTemplate.getForObject("https://fakestoreapi.com/products/",FakeStoreProductDto[].class);

        List<Product> answer = new ArrayList<>();

        for(FakeStoreProductDto productDto : response){
            answer.add(convertFakeStoreProductToProduct(productDto));
        }
        return answer;
    }



    @Override
    public Product replaceProduct(Long id, Product product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getDescription());
        fakeStoreProductDto.setImage(product.getImageUrl());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return convertFakeStoreProductToProduct(response);
    }


}
