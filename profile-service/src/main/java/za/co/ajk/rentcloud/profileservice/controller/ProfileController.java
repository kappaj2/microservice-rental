package za.co.ajk.rentcloud.profileservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.ajk.rentcloud.commons.model.Customer;
import za.co.ajk.rentcloud.profileservice.services.CustomerService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    private static final Logger log = Logger.getLogger(ProfileController.class.getName());

    private CustomerService customerService;

    public ProfileController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);

    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
//    @PostAuthorize
//            ("returnObject.username == authentication.principal.nickName")
//  Access only if returnObject (customer).username is the same as authentication.principal.nickname
    public Customer findById(@PathVariable(value = "id") Integer customerId) {
        return customerService.findCustomer(customerId);

    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
//    @PreAuthorize("hasAuthority('read_profile')")
//    @PreAuthorize("hasRole('ROLE_admin')")
    @PreAuthorize("#oauth2.hasScope('fooScope') and hasRole('ROLE_admin')")
    public List<Customer> findAllCustomers() {

        log.info("Inside the @Async logic: "
                + SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return customerService.findAllCustomers();

    }
}
