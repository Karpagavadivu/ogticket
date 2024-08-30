package com.project.customerprofile.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.customerprofile.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
