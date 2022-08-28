package com.api.store.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "SKU", nullable = false)
    private String SKU;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
