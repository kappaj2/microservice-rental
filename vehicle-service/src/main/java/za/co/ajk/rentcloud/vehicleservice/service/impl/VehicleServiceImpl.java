package za.co.ajk.rentcloud.vehicleservice.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.ajk.rentcloud.model.vehicle.Vehicle;
import za.co.ajk.rentcloud.vehicleservice.repository.VehicleRepository;
import za.co.ajk.rentcloud.vehicleservice.service.VehicleService;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public Vehicle save(Vehicle customer) {
        return vehicleRepository.save(customer);
    }

    @Override
    public Vehicle findById(int id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);

        if (vehicle.isPresent())
            return vehicle.get();
        else
            return new Vehicle();

    }


    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
