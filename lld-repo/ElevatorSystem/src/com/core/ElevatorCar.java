package com.core;

import com.util.Direction;
import com.util.ElevatorStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class ElevatorCar {

    private static final AtomicInteger count = new AtomicInteger(0);
    int elevatorId;
    int currentFloor;
    ElevatorStatus status;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;


    public ElevatorCar() {
        super();
        this.elevatorId = count.incrementAndGet();
        this.direction = Direction.IDLE;
        this.currentFloor = 0;
        this.status = status.IDLE;
        // use default, which is a min heap
        upQueue = new PriorityQueue<>((a, b) -> a.getDesiredFloor() - b.getDesiredFloor());

        // use a max heap
        downQueue =  new PriorityQueue<>((a, b) -> b.getDesiredFloor() - a.getDesiredFloor());
    }

    public void addToUpQueue(Request request) {
        // TODO Auto-generated method stub
        upQueue.add(request);
    }

    public void addToDownQueue(Request request) {
        // TODO Auto-generated method stub
        downQueue.add(request);
    }
}
