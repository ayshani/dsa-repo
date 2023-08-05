package com.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
1019. Next Greater Node In Linked List

You are given the head of a linked list with n nodes.

For each node in the list, find the value of the next greater node. That is, for each node, find the value of the
first node that is next to it and has a strictly larger value than it.

Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed).
If the ith node does not have a next greater node, set answer[i] = 0.

Example 1:
Input: head = [2,1,5]
Output: [5,5,0]

TC : o(n)
SC: o(n)
 */
public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next =  new ListNode(8);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(Arrays.toString(new NextGreaterNodeInLinkedList().nextLargerNodes(head1)));
    }
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> A = new ArrayList<>();
        while(head!=null){
            A.add(head.val);
            head = head.next;
        }
        int[] res = new int[A.size()];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<A.size();i++){
            while(!st.isEmpty() && A.get(st.peek())<A.get(i)){
                res[st.pop()] = A.get(i);
            }
            st.push(i);
        }
        return res;
    }
}
