package com.api.store.repository;

import com.api.store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM customers " +
                   "WHERE email = :email AND password = :password", nativeQuery = true)
    List<Customer> login(@Param("email") String email, @Param("password") String password);

    List<Customer> findByEmail(String email);
}
