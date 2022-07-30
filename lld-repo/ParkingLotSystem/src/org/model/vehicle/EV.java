package org.model.vehicle;

import org.model.util.VehicleType;

public class EV extends Vehicle{
    public EV(String licenseNumber) {
        super(licenseNumber, VehicleType.EV);
    }
}
