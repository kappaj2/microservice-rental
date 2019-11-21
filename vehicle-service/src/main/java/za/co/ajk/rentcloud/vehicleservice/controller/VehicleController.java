package za.co.ajk.rentcloud.vehicleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.ajk.rentcloud.model.vehicle.Vehicle;
import za.co.ajk.rentcloud.vehicleservice.service.VehicleService;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/services/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);
    }

    @GetMapping(value = "/{id}")
    public Vehicle getVehicle(@PathVariable int id) {
        System.out.println("getVehicle : request came on " + LocalDateTime.now() + "  ++++++++++++++++++++++");
        return vehicleService.findById(id);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        System.out.println("getAllVehicles : request came on " + LocalDateTime.now() + "  ++++++++++++++++++++++");
        return vehicleService.findAll();
    }

}
