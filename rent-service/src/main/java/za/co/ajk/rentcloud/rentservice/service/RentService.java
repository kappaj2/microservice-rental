package za.co.ajk.rentcloud.rentservice.service;


import za.co.ajk.rentcloud.model.rent.Rent;
import za.co.ajk.rentcloud.rentservice.model.DetailResponse;

import java.util.List;

public interface RentService {
    Rent save(Rent customer);

    Rent findById(int id);

    List<Rent> findAll();

    DetailResponse findDetailResponse(int id);
}
