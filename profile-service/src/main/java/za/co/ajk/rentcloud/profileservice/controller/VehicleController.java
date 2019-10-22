package za.co.ajk.rentcloud.profileservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.ajk.rentcloud.commons.model.Vehicle;
import za.co.ajk.rentcloud.profileservice.services.VehicleService;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.POST)
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return vehicleService.save(vehicle);

    }

    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
    public Vehicle findById(@PathVariable Integer id) {
        return vehicleService.findVehicle(id);

    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public List<Vehicle> findAllVehicles() {
        return vehicleService.findAllVehicles();

    }
}
