package com.prac.product_category_two_entity_case_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prac.product_category_two_entity_case_study.dto.Product;
import com.prac.product_category_two_entity_case_study.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create Product (with categoryId)
    @PostMapping("/{categoryId}")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product,
                                               @PathVariable int categoryId) {
        return ResponseEntity.ok(productService.saveProduct(product, categoryId));
    }

    // Get All Products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Get Product By Id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // Update Product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id,
                                                 @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    // Get Products By Category
    @GetMapping("/category/{cid}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable int cid) {
        return ResponseEntity.ok(productService.getProductsByCategory(cid));
    }

    // Search Product By Name
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.searchProductByName(name));
    }
}