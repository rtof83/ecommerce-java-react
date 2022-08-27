package com.api.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customerId", nullable = false)
    private long customerId;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "date", nullable = false)
    private Date date;
}