package com.controller;

import com.core.ElevatorCar;
import com.core.Request;
import com.util.Direction;

public class ElevatorController {

    ElevatorCar elevator;

    public ElevatorController() {
        super();
    }

    public ElevatorController(ElevatorCar elevator) {
        super();
        this.elevator = elevator;
    }

    public void createElevator() {
        this.elevator = new ElevatorCar();
    }


    public void sendRequest(Direction direction, int destinationFloor) {
        Request request = new Request(this.elevator.getCurrentFloor(),destinationFloor,direction);
        if(direction == Direction.UP) {
            elevator.addToUpQueue(request);
            System.out.println("Append up request going to floor " + request.getDesiredFloor() + ".");
        }
        else {
            elevator.addToDownQueue(request);
            System.out.println("Append down request going to floor " + request.getDesiredFloor() + ".");
        }
    }

    public boolean isElevatorInUse() {
        // TODO Auto-generated method stub
        if(!elevator.getUpQueue().isEmpty() || !elevator.getDownQueue().isEmpty())
            return true;
        return false;
    }

    public void processRequests() {
        // TODO Auto-generated method stub
        if(this.elevator.getDirection()==Direction.UP || this.elevator.getDirection()==Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        }else {
            processDownRequest();
            processUpRequest();
        }
    }

    private void processDownRequest() {
        // TODO Auto-generated method stub
        while(!this.elevator.getDownQueue().isEmpty()) {
            Request downRequest = this.elevator.getDownQueue().poll();
            this.elevator.setCurrentFloor(downRequest.getDesiredFloor());
            System.out.println("Processing down requests. Elevator stopped at floor " + this.elevator.getCurrentFloor() + ".");

        }

        if(!this.elevator.getUpQueue().isEmpty()) {
            this.elevator.setDirection(Direction.UP);
        } else
            this.elevator.setDirection(Direction.IDLE);

    }

    private void processUpRequest() {
        // TODO Auto-generated method stub
        while(!this.elevator.getUpQueue().isEmpty()) {
            Request upRequest = this.elevator.getUpQueue().poll();
            this.elevator.setCurrentFloor(upRequest.getDesiredFloor());
            System.out.println("Processing up requests. Elevator stopped at floor " + this.elevator.getCurrentFloor() + ".");
        }

        if(!this.elevator.getDownQueue().isEmpty()) {
            this.elevator.setDirection(Direction.DOWN);
        } else
            this.elevator.setDirection(Direction.IDLE);
    }
}
