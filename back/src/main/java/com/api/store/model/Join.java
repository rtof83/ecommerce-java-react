package com.api.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
//@Table(name="join")
public class Join {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer", nullable = false)
    private String customer;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "date")
    private Date date;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private List<Item> items;
}
