package com.example.codeup.springblog.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
//creating a table from the bean using these annotations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
//    how to specify what you want the column properties to be
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;


    private int priceInCents;

    public Product() {
    }

    public Product(String name, int priceInCents) {
        this.name = name;
        this.priceInCents = priceInCents;
    }

    public Product(Long id, String name, int priceInCents) {
        this.id = id;
        this.name = name;
        this.priceInCents = priceInCents;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }
}
