package com.core.dispatcher;

import com.controller.ElevatorController;
import com.util.Direction;

public class ExternalDispatcher {
    ElevatorController elevatorController;

    public ExternalDispatcher(ElevatorController elevatorController) {
        super();
        this.elevatorController = elevatorController;
    }

    public void pressButtonFromOutside(Direction direction, int currentFloor) {
        this.elevatorController.sendRequest(direction,currentFloor);
    }

}
