package za.co.ajk.rentcloud.profileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.ajk.rentcloud.commons.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
