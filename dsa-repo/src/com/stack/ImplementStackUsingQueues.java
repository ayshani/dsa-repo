package com.stack;

import java.util.LinkedList;
import java.util.Queue;

/*
225. Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the
functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front,
size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or
deque (double-ended queue) as long as you use only a queue's standard operations.


Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.top()); // return 1
        System.out.println(myStack.empty()); // return False
    }
}

class MyStack {
    Queue<Integer> q1, q2;
    int top;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        top = -1;
    }

    public void push(int x) {
        q1.offer(x);
        top = x;
    }

    public int pop() {
        while(q1.size()>1){
            top =  q1.poll();
            q2.offer(top);
        }
        int value = q1.poll();
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return value;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
