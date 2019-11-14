package za.co.ajk.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.ajk.rentcloud.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
