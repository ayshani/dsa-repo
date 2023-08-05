package com.linkedlist;
/*
82. Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

TC : o(n)
SC: o(n)
 */
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(5);
        head.next.next = new ListNode(7);
        head.next.next.next =  new ListNode(7);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(9);
        head = new RemoveDuplicatesFromSortedListII().deleteDuplicates(head);
        new PrintLinkedList().print(head);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head== null)
            return head;
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast!= null){
            while(fast.next!=null && fast.val == fast.next.val){
                fast = fast.next;//while loop to find the last node of the dups.
            }
            if(slow.next!=fast){//duplicates detected.
                slow.next = fast.next;//remove the dups.
                fast = slow.next;//reposition the fast pointer.
            }else{//no dup, move down both pointer.
                slow=slow.next;
                fast= fast.next;
            }
        }
        return dummy.next;
    }
}
