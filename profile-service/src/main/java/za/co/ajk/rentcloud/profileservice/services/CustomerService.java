package za.co.ajk.rentcloud.profileservice.services;

import za.co.ajk.rentcloud.commons.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer findCustomer(Integer id);

    List<Customer> findAllCustomers();
}
