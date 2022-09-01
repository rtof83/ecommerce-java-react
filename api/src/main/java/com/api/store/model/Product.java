package com.api.store.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="products")
public class Product {

    @Id
    @Column(nullable = false, length = 50)
    private String sku;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "descr")
    private String descr;

    @Column(name = "image")
    private String image;
}
