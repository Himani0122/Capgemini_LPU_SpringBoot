package com.prac.product_category_two_entity_case_study.dto;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    private String name;
    private String description;

    public Category() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}