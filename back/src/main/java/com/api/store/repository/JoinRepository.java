package com.api.store.repository;

import com.api.store.model.Join;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinRepository extends JpaRepository<Join, Long> {


//    @Query(value = "SELECT orders.id, customers.name AS customer, orders.address, orders.date, orders.total " +
//                   "FROM orders " +
//                   "INNER JOIN customers " +
//                   "ON customers.id = orders.customer_id", nativeQuery = true)

//    interface MainEntityProjection {
//        Long id();
//        String name();
//    }

    @Query(value = "SELECT O.id, C.name AS customer, O.address, O.total, O.date\n" +
                   "FROM orders O\n" +
                   "INNER JOIN customers C\n" +
                   "ON C.id = O.customer_id", nativeQuery = true)

//    @Query(value = "SELECT * FROM customers", nativeQuery = true)
//    @Query("SELECT client FROM Client client")
    List<Join> getJoin();
}
