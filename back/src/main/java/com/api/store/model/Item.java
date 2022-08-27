package com.api.store.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="items")
public class Item {

    @Id
    private long orderId;

    @Id
    private long productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
