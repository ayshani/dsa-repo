package org.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.model.util.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class ParkingLot {

    private String parkingLotId;
    private Address address;

    private List<ParkingFloor> parkingFloors;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;

    // private constructor to restrict singleton
    private ParkingLot() {
        this.parkingLotId = UUID.randomUUID().toString();
        this.parkingFloors = new ArrayList<>();
        this.entrancePanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
    }


    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    private static ParkingLot parkingLot = null;

    public static ParkingLot getInstance() {
        if(parkingLot==null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public boolean isFull() {
        /*
         * check in all parking floors, if any floor is not empty,
         * that means Parking lot is not empty
         */
        for(ParkingFloor parkingfloor : parkingFloors) {
            if(!parkingfloor.isFloorFull())
                return false;
        }
        return true;
    }

    public boolean canPark(VehicleType vehicleType){

        for(ParkingFloor parkingFloor : parkingFloors){
            if(parkingFloor.canPark(vehicleType))
                return true;
        }
        return false;
    }

    public ParkingSpot getParkingSpot(VehicleType vehicleType){
        for(ParkingFloor parkingFloor : parkingFloors){
            ParkingSpot parkingSpot = parkingFloor.getParkingSpot(vehicleType);
            if(null != parkingSpot)
                return parkingSpot;
        }
        return null;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId){
        for(ParkingFloor parkingFloor : parkingFloors){
            ParkingSpot parkingSpot = parkingFloor.vacateParkingSpot(parkingSpotId);
            if(null != parkingSpot)
                return parkingSpot;
        }
        return null;
    }
}
