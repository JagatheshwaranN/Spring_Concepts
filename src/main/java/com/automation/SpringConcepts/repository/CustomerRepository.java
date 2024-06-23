package com.automation.SpringConcepts.repository;

import com.automation.SpringConcepts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstNameStartingWith(String firstName);
    List<Customer> findByDobBetween(Date from, Date to);
}
