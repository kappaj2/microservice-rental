package za.co.ajk.rentcloud.profileservice.services.impl;

import org.springframework.stereotype.Service;
import za.co.ajk.rentcloud.commons.model.Customer;
import za.co.ajk.rentcloud.profileservice.repository.CustomerRepository;
import za.co.ajk.rentcloud.profileservice.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findCustomer(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        customerOptional.orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerOptional.get();
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
