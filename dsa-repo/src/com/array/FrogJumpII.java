package com.array;
/*
2498. Frog Jump II

You are given a 0-indexed integer array stones sorted in strictly increasing order representing the positions
of stones in a river.

A frog, initially on the first stone, wants to travel to the last stone and then return to the first stone.
However, it can jump to any stone at most once.

The length of a jump is the absolute difference between the position of the stone the frog is currently on and
the position of the stone to which the frog jumps.

More formally, if the frog is at stones[i] and is jumping to stones[j], the length of the jump is
|stones[i] - stones[j]|.
The cost of a path is the maximum length of a jump among all jumps in the path.

Return the minimum cost of a path for the frog.



Example 1:
Input: stones = [0,2,5,6,7]
Output: 5
Explanation: The above figure represents one of the optimal paths the frog can take.
The cost of this path is 5, which is the maximum length of a jump.
Since it is not possible to achieve a cost of less than 5, we return it.


Intuition 1
"travel to the last stone and then return to the first stone."
It means there are two path from first to last stone,
and two path have no intersection in the middle.
We can image there are two frog jump from first to the last.

Intuition 2
If one stone not in path one and path 2,
we can greedily add it to either of the path.
So it exists a best solution, that all stones are used.


Explanation
So we are going to assign stones to two frogs alternatively:
A[0] A[1] A[2] A[3] ...
start frog1 frog2 frog1 ...

If we assign them not alternatively like:
frog1 frog2 frog2 frog1

The distance for frog 1 is huge and it's no better than
frog1 frog2 frog1 frog2

So in this problem,
we need to calculate the maximunm distance between A[i] - A[i-2].
Special case is only two stones, so we initial res = A[1] - A[0].

TC : o(n)
SC: o(1)
 */
public class FrogJumpII {
    public static void main(String[] args) {
        int[] stones = new int[]{0,2,5,6,7};
        System.out.println(new FrogJumpII().maxJump(stones));
    }
    public int maxJump(int[] stones) {
        int res = stones[1]-stones[0], n = stones.length;
        for(int i=2;i<n;i++){
            res = Math.max(res, stones[i] -stones[i-2]);
        }
        return res;
    }
}
