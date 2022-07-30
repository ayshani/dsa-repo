package org.model.parking;

import org.model.util.ParkingSpotType;

public class ElectricBikeParkingSpot extends ParkingSpot {

    public ElectricBikeParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.EBIKE);
    }

}