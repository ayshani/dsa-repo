package org.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.model.util.ParkingSpotType;
import org.model.util.VehicleType;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ParkingFloor {

    @Getter
    @Setter
    private String floorId;
    @Getter
    private Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots; // available parking spots to use for parking
    @Getter
    private Map<String,ParkingSpot> usedParkingSpots; // used parkingSpots once a vehicle gets parked

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        parkingSpots = new HashMap<>();
        usedParkingSpots = new HashMap<>();
        parkingSpots.put(ParkingSpotType.CAR, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.MOTERBIKE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.ELECTRIC, new ConcurrentLinkedDeque<>());
    }

    /**
     * Iterate over all types of parkingSpots,
     * In case if any of the spots is not empty,
     * 		that means the floor itself is not empty
     * else
     * 		the whole floor is empty
     * @return
     */
    public boolean isFloorFull() {
        for(Map.Entry<ParkingSpotType,Deque<ParkingSpot>> entry : parkingSpots.entrySet()) {
            if(entry.getValue().size()!=0)
                return false;
        }
        return true;
    }

    public static ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        switch(vehicleType) {
            case CAR:
                return ParkingSpotType.CAR;
            case EV :
                return ParkingSpotType.ELECTRIC;
            case MOTORBIKE :
                return ParkingSpotType.MOTERBIKE;
            default:
                return ParkingSpotType.LARGE;
        }
    }

    public boolean canPark(VehicleType vehicleType) {
        return isSpotAvailable(getSpotTypeForVehicle(vehicleType));
    }

    private boolean isSpotAvailable(ParkingSpotType spotTypeForVehicle) {
        return parkingSpots.get(spotTypeForVehicle).size()>0;
    }

    public synchronized ParkingSpot getParkingSpot(VehicleType vehicleType) {
        // No space available for this vehicleType in this floor
        if(!canPark(vehicleType))
            return null;
        // Get parking spot type
        ParkingSpotType parkingSpotType = getSpotTypeForVehicle(vehicleType);
        /*
         * Remove from available parking spot
         */
        ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll();

        // add the spot in usedPakringSpot map
        usedParkingSpots.put(parkingSpot.getParkingSpotId(),parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId) {
        // Removed from used parking spot map
        ParkingSpot parkingSpot = usedParkingSpots.remove(parkingSpotId);
        // incase parkingSpotId is valid one, then it will remove and we will get one
        // spot
        if(null !=parkingSpot) {
            /*
             * free the spot
             */
            parkingSpot.freeSpot();
            // Add the spot in available map of spots
            parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
            return parkingSpot;
        }
        return null;
    }
}
