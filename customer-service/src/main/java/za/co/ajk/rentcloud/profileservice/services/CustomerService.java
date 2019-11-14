package za.co.ajk.rentcloud.profileservice.services;

import za.co.ajk.rentcloud.model.customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();
}
