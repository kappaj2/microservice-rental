package za.co.ajk.rentcloud.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.ajk.rentcloud.model.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
