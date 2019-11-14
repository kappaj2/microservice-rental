package za.co.ajk.rentcloud.rentcloudtask.services.impl;

import org.springframework.stereotype.Service;
import za.co.ajk.rentcloud.rentcloudtask.services.RentProcessService;

@Service
public class RentProcessServiceImpl implements RentProcessService {

    @Override
    public boolean validateDL(String dlNumber) {
        return dlNumber.length() > 5;
    }
}
