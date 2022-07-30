package org.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.model.exception.ParkingLotFullException;
import org.model.util.TicketStatus;
import org.model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class EntrancePanel {
    private String id;

    public EntrancePanel(String id) {
        this.id = id;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) throws ParkingLotFullException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        if(!parkingLot.canPark(vehicle.getType()))
            throw new ParkingLotFullException("parking Lot full");

        ParkingSpot  parkingSpot = parkingLot.getParkingSpot(vehicle.getType());
        if(null == parkingSpot)
            return null;
        // Assign vehicle to parking spot
        parkingSpot.assignVechicleToSpot(vehicle.getLicenseNumber());
        return buildTicket(vehicle.getLicenseNumber(),parkingSpot.getParkingSpotId());
    }

    private ParkingTicket buildTicket(String licenseNumber, String parkingSpotId) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setIssuedAt(LocalDateTime.now());
        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);
        parkingTicket.setLicensePlateNumber(licenseNumber);
        parkingTicket.setAllocatedSpotId(parkingSpotId);
        return parkingTicket;
    }
}
