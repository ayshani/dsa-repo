package com.linkedlist;
/*
160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:
The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to
your program. If you correctly return the intersected node, then your solution will be accepted.

Example 1:
Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
    There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in
    A and 3rd node in B) are different node references. In other words, they point to two different locations
    in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location
    in memory.

TC: o(n)
SC: o(n)
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next =  new ListNode(8);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        head2.next.next.next =  head1.next.next;

        new PrintLinkedList().print(new IntersectionOfTwoLinkedLists().getIntersectionNode(head1,head2));
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

        int lengthA = length(headA);
        int lengthB = length(headB);
        int diff = Math.abs(lengthA-lengthB);

        ListNode tempA = headA, tempB = headB;
        if(lengthA<lengthB){
            tempA = headB;
            tempB = headA;
        }

        while(diff>0){
            tempA = tempA.next;
            diff--;
        }

        while(tempA!= null && tempB!=null && tempA!=tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if(tempA!=null && tempB!=null && tempA==tempB){
            return tempA;
        }
        return null;
    }

    private int length(ListNode head) {
        if(head== null)
            return 0;
        int count =0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}
