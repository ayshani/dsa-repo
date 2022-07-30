package com.core;

import com.util.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {

    private int currentFloor;
    private int desiredFloor;
    private Direction direction;


    public Request(int currentFloor, int desiredFloor, Direction direction) {
        super();
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
    }
}
