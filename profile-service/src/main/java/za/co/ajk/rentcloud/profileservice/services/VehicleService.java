package za.co.ajk.rentcloud.profileservice.services;

import za.co.ajk.rentcloud.commons.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    Vehicle findVehicle(Integer id);

    List<Vehicle> findAllVehicles();
}
