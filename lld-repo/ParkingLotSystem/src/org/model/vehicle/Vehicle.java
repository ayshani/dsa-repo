package org.model.vehicle;

import lombok.Getter;
import lombok.Setter;
import org.model.parking.PlayingTicket;
import org.model.util.VehicleType;

@Getter
@Setter
public abstract class Vehicle {
    private String licenseNumber;
    private VehicleType type;
    private PlayingTicket ticket;


    public Vehicle(String licenseNumber, VehicleType type) {
        super();
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

}