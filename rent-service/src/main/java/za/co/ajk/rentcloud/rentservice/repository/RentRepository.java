package za.co.ajk.rentcloud.rentservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.co.ajk.rentcloud.model.rent.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer> {
}
