package com.project.productservicedecmwfeve.repositories;

import com.project.productservicedecmwfeve.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


//Here Product is the class fo4r which a table is created for its components
//Long is the data type of the primary key
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByTitleContainingAllIgnoreCase(String word);
    long deleteByTitle(String title);

    List<Product> findByTitleAndDescriptionLikeOrderByDescription(String title, String description);


    //Here we derived the product list based on a particular category id, "_: is used for derived queries
    List<Product> findByCategory_Id(Long id);

    @Query("SELECT p FROM Product p")
    List<Product> findAll();
    boolean existsById(Long id);



}
