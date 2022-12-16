package com.design;

import java.util.Random;

/*
1206. Design Skiplist

Design a Skiplist without using any built-in libraries.

A skiplist is a data structure that takes O(log(n)) time to add, erase and search.
Comparing with treap and red-black tree which has the same function and performance,
the code length of Skiplist can be comparatively short and the idea behind Skiplists is just simple linked lists.

For example, we have a Skiplist containing [30,40,50,60,70,90] and we want to add 80 and 45 into it.

Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons

You can see there are many layers in the Skiplist.
Each layer is a sorted linked list. With the help of the top layers, add, erase and search can be faster than O(n).
It can be proven that the average time complexity for each operation is O(log(n)) and space complexity is O(n).

See more about Skiplist: https://en.wikipedia.org/wiki/Skip_list

Implement the Skiplist class:

Skiplist() Initializes the object of the skiplist.
bool search(int target) Returns true if the integer target exists in the Skiplist or false otherwise.
void add(int num) Inserts the value num into the SkipList.
bool erase(int num) Removes the value num from the Skiplist and returns true.
If num does not exist in the Skiplist, do nothing and return false. If there exist multiple num values,
removing any one of them is fine.
Note that duplicates may exist in the Skiplist, your code needs to handle this situation.



Example 1:

Input
["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
[[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
Output
[null, null, null, null, false, null, true, false, true, false]

Explanation
Skiplist skiplist = new Skiplist();
skiplist.add(1);
skiplist.add(2);
skiplist.add(3);
skiplist.search(0); // return False
skiplist.add(4);
skiplist.search(1); // return True
skiplist.erase(0);  // return False, 0 is not in skiplist.
skiplist.erase(1);  // return True
skiplist.search(1); // return False, 1 has already been erased.

Explanation -
https://leetcode.com/problems/design-skiplist/solutions/394985/a-java-solution-using-only-random-number-library/
https://www.youtube.com/watch?v=7pWkspmYUVo&t=1617s

 */
public class DesignSkiplist {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0)); // return False
        skiplist.add(4);
        System.out.println(skiplist.search(1)); // return True
        System.out.println(skiplist.erase(0));  // return False, 0 is not in skiplist.
        System.out.println(skiplist.erase(1));  // return True
        System.out.println(skiplist.search(1)); // return False, 1 has already been erased.
    }
}

class Skiplist {
    SkipListNode head, tail;
    Random rand = new Random();
    public Skiplist() {
        head = new SkipListNode(Integer.MIN_VALUE);
        tail = new SkipListNode(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public boolean search(int target) {
        return target == getEqualOrSmaller(target,head).val;
    }

    public void add(int num) {
        SkipListNode prev = getEqualOrSmaller(num,head);
        SkipListNode cur = new SkipListNode(num);
        insert(prev,cur);
        levelUp(cur);
    }

    public boolean erase(int num) {
        SkipListNode prev = getEqualOrSmaller(num,head);
        if(prev.val!=num)
            return false;
        remove(prev);
        return true;

    }

    private SkipListNode getEqualOrSmaller(int val, SkipListNode start){
        if(start.next.val<=val)
            return getEqualOrSmaller(val,start.next);
        else{
            if(start.down!=null)
                return getEqualOrSmaller(val,start.down);
            else
                return start;
        }
    }

    private void insert(SkipListNode prevNode, SkipListNode cur){
        SkipListNode prevNext = prevNode.next;
        prevNode.next = cur;
        cur.prev = prevNode;
        cur.next = prevNext;
        prevNext.prev = cur;

    }

    private void levelUp(SkipListNode cur){
        if(flip()){
            SkipListNode prevNode = cur.prev;
            while(prevNode!=null && prevNode.up==null){
                prevNode = prevNode.prev;
            }
            if(prevNode==null){
                SkipListNode newHead = new SkipListNode(Integer.MIN_VALUE);
                SkipListNode newTail = new SkipListNode(Integer.MAX_VALUE);
                newHead.down = head;
                head.up = newHead;
                newTail.down = tail;
                tail.up = newTail;
                newHead.next = newTail;
                newTail.prev = newHead;
                head = newHead;
                tail = newTail;
                prevNode = head.down;
            }
            SkipListNode upCur = new SkipListNode(cur.val);
            upCur.down = cur;
            cur.up = upCur;
            insert(prevNode.up,upCur);
            levelUp(upCur);
        }
    }

    private boolean flip(){
        return rand.nextInt(2)==1;
    }

    private void remove(SkipListNode cur){
        if(cur == null)
            return;
        SkipListNode prevNode = cur.prev, nextNode = cur.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        remove(cur.up);
    }
}

class SkipListNode{
    int val;
    SkipListNode next, prev, up, down;
    SkipListNode(int v){
        this.val = v;
    }
}
