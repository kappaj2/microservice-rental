package za.co.ajk.rentcloud.rentservice.model;


import za.co.ajk.rentcloud.model.rent.Rent;
import za.co.ajk.rentcloud.rentservice.model.Response;

public class SimpleResponse implements Response {

    Rent rent;


    public SimpleResponse(Rent rent) {
        this.rent = rent;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
