package org.model.account;

import org.model.exception.InvalidParkingFloorException;
import org.model.parking.*;

import java.util.Optional;

public class Admin extends Account {

    public void addParkingFloor(ParkingFloor parkingFloor) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        Optional<ParkingFloor> floor =
                parkingLot.getParkingFloors().stream().
                        filter(pF -> pF.getFloorId().equalsIgnoreCase(parkingFloor.getFloorId()))
                        .findFirst();

        if (floor.isPresent())
            return;
        parkingLot.getParkingFloors().add(parkingFloor);
        //System.out.println(parkingLot.getParkingFloors().size() +" wufiuwf");
    }

    public void addParkingSpot(String parkingFloorId, ParkingSpot parkingSpot) throws InvalidParkingFloorException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        Optional<ParkingFloor> floor = parkingLot.getParkingFloors().stream()
                .filter(pF -> pF.getFloorId().equalsIgnoreCase(parkingFloorId))
                .findFirst();

        if (!floor.isPresent()) {
            throw new InvalidParkingFloorException("Invalid Floor");
        }

        Optional<ParkingSpot> spot = floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType())
                .stream().filter(ps -> ps.getParkingSpotId().equalsIgnoreCase(parkingSpot.getParkingSpotId()))
                .findFirst();

        if (spot.isPresent())
            return;

        floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType()).add(parkingSpot);

    }

    public void addEntrancePanel(EntrancePanel entrancePanel) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        Optional<EntrancePanel> panel =
                parkingLot.getEntrancePanels().stream().filter(eP -> eP.getId().equalsIgnoreCase(entrancePanel.getId())).findFirst();

        if (panel.isPresent())
            return;

        parkingLot.getEntrancePanels().add(entrancePanel);

    }

    public void addExitpanel(ExitPanel exitPanel) {
        ParkingLot parkinglot = ParkingLot.getInstance();
        Optional<ExitPanel> panel = parkinglot.getExitPanels().stream().filter(eP -> eP.getId().equalsIgnoreCase(exitPanel.getId())).findFirst();

        if (panel.isPresent())
            return;
        parkinglot.getExitPanels().add(exitPanel);
    }
}
