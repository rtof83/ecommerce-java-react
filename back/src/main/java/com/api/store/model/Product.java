package com.api.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Float price;

//    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
//    private List<Item> items;
}
