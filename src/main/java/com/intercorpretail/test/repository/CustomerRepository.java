package com.intercorpretail.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intercorpretail.test.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
