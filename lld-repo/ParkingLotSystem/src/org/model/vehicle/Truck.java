package org.model.vehicle;

import org.model.util.VehicleType;

public class Truck extends Vehicle{
    public Truck(String licenseNumber) {
        super(licenseNumber, VehicleType.TRUCK);
    }
}
