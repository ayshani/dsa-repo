package com.core;

import com.core.dispatcher.InternalDispatcher;

public class InternalButtons {

    ElevatorCar elevator;
    InternalDispatcher dispacther;
    int[] availableButtons = new int[] { 1,2,3,4,5,6,7,8,9,10};
    int buttonSelected;


    public InternalButtons(ElevatorCar elevator) {
        super();
        this.elevator = elevator;
        //this.dispacther = new InternalDispatcher();
    }
}
