package org.model.parking;

import org.model.util.ParkingSpotType;

public class MotorBikeParkingSpot extends ParkingSpot {

    public MotorBikeParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.MOTERBIKE);
    }

}
