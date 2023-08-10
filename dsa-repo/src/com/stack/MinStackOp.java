package com.stack;
/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class MinStackOp {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
}

class MinStack{
    ListNode node;

    public MinStack(){
        node = null;
    }

    public void push(int val){
        ListNode cur = new ListNode();
        cur.val = val;
        if(node == null){
            cur.minVal = val;
        } else{
            cur.minVal = Math.min(cur.val, node.minVal);
            cur.next = node;
        }
        node = cur;
    }

    public void pop(){
        node = node.next;
    }

    public int top()
    {
        if(node!=null)
            return node.val;
        return -1;
    }


    public int getMin()
    {
        if(node!=null)
            return node.minVal;
        return -1;
    }

}
class ListNode{
    int val, minVal;
    ListNode next;
}
