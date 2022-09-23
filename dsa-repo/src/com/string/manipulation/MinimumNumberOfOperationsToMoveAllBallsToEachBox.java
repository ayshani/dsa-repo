package com.string.manipulation;

import java.util.Arrays;

/*
1769. Minimum Number of Operations to Move All Balls to Each Box

You have n boxes. You are given a binary string boxes of length n,
where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.

In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
Note that after doing so, there may be more than one ball in some boxes.

Return an array answer of size n, where answer[i] is the minimum number of operations needed to move
all the balls to the ith box.

Each answer[i] is calculated considering the initial state of the boxes.

Example 1:

Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations,
and move one ball from the second box to the third box in one operation.

Logic
------
We first "move" balls from left to right, and track how many ops it takes for each box.
For that, we count how many balls we got so far in cnt, and accumulate it in ops.
Then, we do the same from right to left.

TC : o(n)
SC : o(n)
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        int[] res = new MinimumNumberOfOperationsToMoveAllBallsToEachBox().minOperations("001011");
        Arrays.stream(res).forEach(e-> System.out.print(e+" "));
    }
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];

        for(int i=0,ops=0,count=0;i<n;i++){
            res[i]+=ops;
            count+= boxes.charAt(i)=='1'? 1: 0;
            ops+=count;
        }

        for(int i=n-1,ops=0,count=0;i>=0;i--){
            res[i]+=ops;
            count+= boxes.charAt(i)=='1'? 1: 0;
            ops+=count;
        }

        return res;
    }
}
