package za.co.ajk.rentcloud.rentservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.ajk.rentcloud.model.rent.Rent;
import za.co.ajk.rentcloud.rentservice.model.Response;
import za.co.ajk.rentcloud.rentservice.model.SimpleResponse;
import za.co.ajk.rentcloud.rentservice.service.RentService;

import java.util.List;

@RestController
@RequestMapping("/services/rents")
public class RentController {


    @Autowired
    RentService rentService;

    @PostMapping
    public Rent save(@RequestBody Rent rent) {
        return rentService.save(rent);
    }

    @GetMapping(value = "/{id}")
    public Response getRent(@PathVariable int id, @RequestParam(required = false) String type) {

        if (type == null) {
            return new SimpleResponse(rentService.findById(id));
        } else {
            return rentService.findDetailResponse(id);
        }


    }

    @GetMapping
    public List<Rent> getAllRents() {
        return rentService.findAll();
    }


}
