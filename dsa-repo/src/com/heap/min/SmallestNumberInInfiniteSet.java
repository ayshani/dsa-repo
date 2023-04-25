package com.heap.min;

import java.util.PriorityQueue;

/*
2336. Smallest Number in Infinite Set

You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the
infinite set.

Example 1:

Input
["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest",
"popSmallest", "popSmallest"]
[[], [2], [], [], [], [1], [], [], []]
Output
[null, null, 1, 2, 3, null, 1, 4, 5]

Explanation
SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
smallestInfiniteSet.popSmallest(); // return 1, since 1 is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 2, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 3, and remove it from the set.
smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
smallestInfiniteSet.popSmallest(); // return 1, since 1 was added back to the set and
                                   // is the smallest number, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 4, and remove it from the set.
smallestInfiniteSet.popSmallest(); // return 5, and remove it from the set.

TC : o(logn)
SC: n
 */
public class SmallestNumberInInfiniteSet {
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(1);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}

class SmallestInfiniteSet {
    PriorityQueue<Integer> q;
    int current;
    public SmallestInfiniteSet() {
        q = new PriorityQueue<>();
        current =1;
    }

    public int popSmallest() {
        int result = current;
        // incase we add some smaller value later in queue,
        // then current can be higher than actual smallest one. So, below check
        // will handle that
        if(!q.isEmpty() && q.peek()<current){
            result =q.poll();
        } else{
            // incase above if is not valid, that means our current is the smallest one. so, next smallest
            // will be current++
            current++;
        }

        // Now, once result i.e. smallest is decided, we need to remove all occurrences
        // of that from queue
        while(!q.isEmpty() && q.peek()== result){
            q.poll();
        }
        return result;
    }

    public void addBack(int num) {
        q.add(num);
    }
}