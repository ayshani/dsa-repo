package org.model.vehicle;

import org.model.util.VehicleType;

public class MotorBike extends Vehicle{
    public MotorBike(String licenseNumber) {
        super(licenseNumber, VehicleType.MOTORBIKE);
    }
}
