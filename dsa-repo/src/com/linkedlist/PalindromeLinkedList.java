package com.linkedlist;
/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome.

Example 1:
Input: head = [1,2,2,1]
Output: true


Example 2:
Input: head = [1,2]
Output: false
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next =  new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(new PalindromeLinkedList().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow= slow.next;
        }
        ListNode rev = ReverseLinkedList.reverse(slow);
        slow  = head;
        while(rev!=null){
            if(slow.val!=rev.val)
                return false;
            slow=slow.next;
            rev = rev.next;
        }
        return true;

    }

}
