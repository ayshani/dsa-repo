package com.core.dispatcher;

import com.controller.ElevatorController;
import com.util.Direction;

public class InternalDispatcher {
    private ElevatorController elevatorController;
    public InternalDispatcher(ElevatorController controller) {
        // TODO Auto-generated constructor stub
        this.elevatorController=controller;
    }

    public void pressButtonFromInside(Direction direction, int destinationFloor) {
        this.elevatorController.sendRequest(direction,destinationFloor);
    }

}
