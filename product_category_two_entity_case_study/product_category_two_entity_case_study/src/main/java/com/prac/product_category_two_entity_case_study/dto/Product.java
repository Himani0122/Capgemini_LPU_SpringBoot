package com.prac.product_category_two_entity_case_study.dto;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;   // ✅ proper field name

    public Product() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}