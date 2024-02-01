package com.project.productservicedecmwfeve.repositories;

import com.project.productservicedecmwfeve.models.Category;
import com.project.productservicedecmwfeve.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
