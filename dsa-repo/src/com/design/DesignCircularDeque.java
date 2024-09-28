package com.design;
/*
641. Design Circular Deque

Design your implementation of the circular double-ended queue (deque).

Implement the MyCircularDeque class:

MyCircularDeque(int k) Initializes the deque with a maximum size of k.
boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false
otherwise.
boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false
otherwise.
boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or
false otherwise.
boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or
false otherwise.
int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
boolean isEmpty() Returns true if the deque is empty, or false otherwise.
boolean isFull() Returns true if the deque is full, or false otherwise.


Example 1:

Input
["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
[[3], [1], [2], [3], [4], [], [], [], [4], []]
Output
[null, true, true, true, false, 2, true, true, true, 4]

Explanation
MyCircularDeque myCircularDeque = new MyCircularDeque(3);
myCircularDeque.insertLast(1);  // return True
myCircularDeque.insertLast(2);  // return True
myCircularDeque.insertFront(3); // return True
myCircularDeque.insertFront(4); // return False, the queue is full.
myCircularDeque.getRear();      // return 2
myCircularDeque.isFull();       // return True
myCircularDeque.deleteLast();   // return True
myCircularDeque.insertFront(4); // return True
myCircularDeque.getFront();     // return 4
 */
public class DesignCircularDeque {

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));  // return True
        System.out.println(myCircularDeque.insertLast(2));  // return True
        System.out.println(myCircularDeque.insertFront(3)); // return True
        System.out.println(myCircularDeque.insertFront(4)); // return False, the queue is full.
        System.out.println(myCircularDeque.getRear());      // return 2
        System.out.println(myCircularDeque.isFull());       // return True
        System.out.println(myCircularDeque.deleteLast());   // return True
        System.out.println(myCircularDeque.insertFront(4)); // return True
        System.out.println(myCircularDeque.getFront());     // return 4
    }
}


class MyCircularDeque {
    private int[] q;
    int maxSize, size, front, rear =-1;

    public MyCircularDeque(int k) {
        q = new int[k];
        maxSize = k;
        size =0;
        front =-1;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if(isFull())
            return false;
        if(front==-1){
            front=0;
            rear=0;
        }
        else if(front==0)
            front=maxSize-1;
        else
            front--;
        q[front]=value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull())
            return false;
        if(front==-1){
            front=0;
            rear=0;
        } else if(rear == maxSize-1)
            rear=0;
        else
            rear++;
        q[rear]=value;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty())
            return false;
        if(front==rear){
            front=-1;
            rear=-1;
        } else{
            if(front==maxSize-1)
                front=0;
            else
                front++;
        }
        return true;

    }

    public boolean deleteLast() {
        if(isEmpty())
            return false;
        if(front==rear){
            front=-1;
            rear=-1;
        } else if(rear==0)
            rear=maxSize-1;
        else
            rear--;
        return true;
    }

    public int getFront() {
        if(isEmpty())
            return -1;
        return q[front];
    }

    public int getRear() {
        if(isEmpty() || rear<0)
            return -1;
        return q[rear];
    }

    public boolean isEmpty() {
        return front==-1;
    }

    public boolean isFull() {
        return (front==0 && rear== maxSize-1) || front==rear+1;
    }
}
