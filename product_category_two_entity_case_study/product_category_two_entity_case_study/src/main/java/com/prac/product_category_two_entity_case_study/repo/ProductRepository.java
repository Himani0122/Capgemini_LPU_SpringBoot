package com.prac.product_category_two_entity_case_study.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prac.product_category_two_entity_case_study.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContaining(String name);

    List<Product> findByCategoryCid(int cid);
}