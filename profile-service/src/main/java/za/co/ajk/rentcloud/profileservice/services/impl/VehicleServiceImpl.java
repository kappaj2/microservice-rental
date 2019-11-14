package za.co.ajk.rentcloud.profileservice.services.impl;

import org.springframework.stereotype.Service;
import za.co.ajk.rentcloud.commons.model.Vehicle;
import za.co.ajk.rentcloud.profileservice.repository.VehicleRepository;
import za.co.ajk.rentcloud.profileservice.services.VehicleService;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findVehicle(Integer id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        vehicleOptional.orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return vehicleOptional.get();
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }
}
