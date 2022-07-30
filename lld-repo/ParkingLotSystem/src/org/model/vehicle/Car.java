package org.model.vehicle;

import org.model.util.VehicleType;

public class Car extends Vehicle{
    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
