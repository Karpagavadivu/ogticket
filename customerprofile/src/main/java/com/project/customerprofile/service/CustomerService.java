package com.project.customerprofile.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.customerprofile.entity.Customer;
import com.project.customerprofile.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

   

    public Customer updateCustomer(Long id, Customer customerDetails) {
        
       return customerRepository.save(customerDetails);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


    public Object findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}