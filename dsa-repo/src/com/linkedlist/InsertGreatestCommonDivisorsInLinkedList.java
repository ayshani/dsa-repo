package com.linkedlist;
/*
2807. Insert Greatest Common Divisors in Linked List

Given the head of a linked list head, in which each node contains an integer value.

Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

Return the linked list after insertion.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.



Example 1:
Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]
Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after
inserting the new nodes (nodes in blue are the inserted nodes).
- We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
- We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
- We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
There are no more adjacent nodes, so we return the linked list.

TC : o(n* log(min(n*m)))
SC: o(log(min(m,n))
 */
public class InsertGreatestCommonDivisorsInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next =  new ListNode(10);
        head.next.next.next = new ListNode(3);
        new PrintLinkedList().print(new InsertGreatestCommonDivisorsInLinkedList().insertGreatestCommonDivisors(head));

    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while(cur!=null){
            if(cur.next!=null){
                int gcdNum = gcd(cur.val,cur.next.val);
                ListNode aux = new ListNode(gcdNum);
                aux.next = cur.next;
                cur.next = aux;
                cur = cur.next.next;
            } else{
                cur = cur.next;
            }
        }
        return head;
    }

    private int gcd(int a, int b){
        if(a==0)
            return b;
        if(b==0)
            return a;
        if(a>b)
            return gcd(a-b,b);
        return gcd(b-a,a);
    }
}
