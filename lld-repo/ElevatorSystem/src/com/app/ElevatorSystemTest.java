package com.app;

import com.util.Direction;

public class ElevatorSystemTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Create an object of ElevatorSystem
        ElevatorSystem system =  new ElevatorSystem();

        //this will instantiate elevator, controller,internal and external Dispatcher to handle request
        system.makeElevatorSystemLive();


        // ask elevator to come to floor-1 for going up
        system.requestElevator(Direction.UP, 1);
        // press 5 from floor -1 to go up to floor -5
        system.goToFloor(Direction.UP, 5);
        // ask elevator to come to floor-3 for going up
        system.requestElevator(Direction.UP, 3);
        // press 6 from floor -3 to go up to floor -6
        system.goToFloor(Direction.UP, 6);

        // ask elevator to come to floor-3 for going down
        system.requestElevator(Direction.DOWN, 3);
        // press 0 from floor -3 to go down to floor -0
        system.goToFloor(Direction.DOWN, 0);

        system.run();
    }

}
