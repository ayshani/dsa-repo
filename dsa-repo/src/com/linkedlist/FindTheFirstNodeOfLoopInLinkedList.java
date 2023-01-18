package com.linkedlist;
/*
Find the first node of loop in linked list
https://practice.geeksforgeeks.org/problems/44bb5287b98797782162ffe3d2201621f6343a4b/1

Given a singly linked list of N nodes. Find the first node of the loop if the linked list has a loop.
If a loop is present return the node data of the first node of the loop else return -1.

Example 1:
1->2->3->4->5-
      |       |
      --------

Output: 3
Explanation:
We can see that there exists a loop
in the given linked list and the first
node of the loop is 3.

TC : o(n)
SC : o(1)
 */
public class FindTheFirstNodeOfLoopInLinkedList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next =  new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;

        System.out.println(new FindTheFirstNodeOfLoopInLinkedList().findFirstNode(head));
    }
    public int findFirstNode(ListNode head){
        //code here
        ListNode temp = head, slow = head, fast = head;
        boolean isLoopPresent = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                isLoopPresent = true;
                break;
            }
        }

        if(fast==null)
            return -1;

        while(slow!=null && temp!=null){
            if(slow==temp){
                return slow.val;
            }
            slow=slow.next;
            temp=temp.next;
        }
        return -1;

    }
}
