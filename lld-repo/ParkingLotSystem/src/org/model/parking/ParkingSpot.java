package org.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.model.util.ParkingSpotType;

@Getter
@Setter
public abstract class ParkingSpot {

    private String parkingSpotId;
    private boolean isFree;
    private ParkingSpotType parkingSpotType;
    private String assignedVehicleId;

    public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType) {
        super();
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.isFree = true;
    }

    public void assignVechicleToSpot(String vehicleId) {
        this.assignedVehicleId = vehicleId;
        this.isFree = false;
    }

    public void freeSpot() {
        this.isFree = true;
        this.assignedVehicleId = null;
    }
}
