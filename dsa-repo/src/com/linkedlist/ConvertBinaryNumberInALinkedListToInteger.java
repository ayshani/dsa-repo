package com.linkedlist;
/*
1290. Convert Binary Number in a Linked List to Integer

Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

The most significant bit is at the head of the linked list.



Example 1:
Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

TC : o(n)
SC: o(1)
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(new ConvertBinaryNumberInALinkedListToInteger().getDecimalValue(head));
    }
    public int getDecimalValue(ListNode head) {
        int num =0;
        while(head!=null){
            num = num *2 +head.val;
            head= head.next;
        }

        return num;
    }
}
