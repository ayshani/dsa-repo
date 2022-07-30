package com.app;

import com.controller.ElevatorController;
import com.core.ElevatorCar;
import com.core.dispatcher.ExternalDispatcher;
import com.core.dispatcher.InternalDispatcher;
import com.util.Direction;

public class ElevatorSystem {

    private ElevatorCar systemElevator;
    private ElevatorController controller;
    private ExternalDispatcher externalDispatcher;
    private InternalDispatcher internalDispatcher;


    public ElevatorSystem() {
        super();
        //makeElevatorSystemLive();
    }

    public void makeElevatorSystemLive() {
        this.systemElevator = new ElevatorCar();
        this.controller =  new ElevatorController(this.systemElevator);
        this.externalDispatcher = new ExternalDispatcher(this.controller);
        this.internalDispatcher = new InternalDispatcher(this.controller);
    }

    public void run()
    {

        while(this.controller.isElevatorInUse()){
            processRequest();
        }
        System.out.println("Finished all requests.");
        this.systemElevator.setDirection(Direction.IDLE);
    }

    private void processRequest() {
        // TODO Auto-generated method stub
        this.controller.processRequests();
    }

    public void requestElevator(Direction direction, int currentFloor) {
        this.externalDispatcher.pressButtonFromOutside(direction, currentFloor);
    }

    public void goToFloor(Direction direction, int destinationFloor) {
        this.internalDispatcher.pressButtonFromInside(direction, destinationFloor);
    }
}
