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

    @Column(name = "productId", nullable = false)
    private long productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
