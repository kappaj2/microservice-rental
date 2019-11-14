package za.co.ajk.rentcloud.profileservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.ajk.rentcloud.model.customer.Customer;
import za.co.ajk.rentcloud.profileservice.services.CustomerService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services/customers")
public class CustomerServiceController {


    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable int id) {

        System.out.println("request came on " + LocalDateTime.now() + "  ++++++++++++++++++++++");
        return customerService.findById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }


}
