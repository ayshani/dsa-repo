package org.model.parking;

import org.model.util.ParkingSpotType;

public class ElectricCarParkingSpot extends ParkingSpot {

    public ElectricCarParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.ELECTRIC);
    }

}
