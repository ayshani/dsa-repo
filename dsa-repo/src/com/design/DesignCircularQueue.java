package com.design;
/*
622. Design Circular Queue

Design your implementation of the circular queue. The circular queue is a linear data structure in which the
operations are performed based on FIFO (First In First Out) principle and the last position is connected back
to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space
in front of the queue. But using the circular queue, we can use the space to store new values.

Implementation the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language.

Example 1:

Input
["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 3, true, true, true, 4]

Explanation
MyCircularQueue myCircularQueue = new MyCircularQueue(3);
myCircularQueue.enQueue(1); // return True
myCircularQueue.enQueue(2); // return True
myCircularQueue.enQueue(3); // return True
myCircularQueue.enQueue(4); // return False
myCircularQueue.Rear();     // return 3
myCircularQueue.isFull();   // return True
myCircularQueue.deQueue();  // return True
myCircularQueue.enQueue(4); // return True
myCircularQueue.Rear();     // return 4

TC : o(1)
SC : o(n)
 */
public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println("Enqueue :" +obj.enQueue(1));
        System.out.println("Enqueue :" +obj.enQueue(2));
        System.out.println("Enqueue :" +obj.enQueue(3));
        System.out.println("Enqueue :" +obj.enQueue(4));

        System.out.println("FRONT element : "+obj.Front());
        System.out.println("REAR element: "+obj.Rear());
        System.out.println("Is Empty : "+obj.isEmpty());
        System.out.println("Is Full : "+obj.isFull());
        System.out.println("Deque : "+obj.deQueue());
        System.out.println("Deque : "+obj.deQueue());
        System.out.println("Is Full : "+obj.isFull());
        System.out.println("REAR element: "+obj.Rear());
        System.out.println("FRONT element: "+obj.Front());

    }
}

class MyCircularQueue {

    int[] queue;
    int front =0, rear=-1, length;
    public MyCircularQueue(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if(!isFull()){
            rear = (rear+1)%queue.length;
            queue[rear] = value;
            length++;
            return true;
        } else{
            return false;
        }
    }

    public boolean deQueue() {
        if(!isEmpty()){
            front = (front+1)%queue.length;
            length--;
            return true;
        } else
            return false;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        if(length==0)
            return true;
        return false;
    }

    public boolean isFull() {
        if(length== queue.length)
            return true;
        return false;
    }
}
