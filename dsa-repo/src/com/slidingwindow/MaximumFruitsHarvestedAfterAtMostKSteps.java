package com.slidingwindow;
/*
2106. Maximum Fruits Harvested After at Most K Steps

Fruits are available at some positions on an infinite x-axis. You are given a 2D integer array fruits where
fruits[i] = [positioni, amounti] depicts amounti fruits at the position positioni. fruits is already sorted
by positioni in ascending order, and each positioni is unique.

You are also given an integer startPos and an integer k. Initially, you are at the position startPos. From any
position, you can either walk to the left or right. It takes one step to move one unit on the x-axis, and you
can walk at most k steps in total. For every position you reach, you harvest all the fruits at that position,
and the fruits will disappear from that position.

Return the maximum total number of fruits you can harvest.

Example 1:

Input: fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
Output: 9
Explanation:
The optimal way is to:
- Move right to position 6 and harvest 3 fruits
- Move right to position 8 and harvest 6 fruits
You moved 3 steps and harvested 3 + 6 = 9 fruits in total.

Logic
------
We binary-search for the leftmost position that we can reach, which is pos - k.

Then, we use a sliding window approach, tracking sum between l and r iterators.

A catch here is figure out the window size. If the right iterator points after the start position, we can:

go right and left ((r - start) * 2 steps), then go left (start - l steps)
or, go left and right ((start - l) * 2 steps), then go right (r - start steps).
The smallest of these two options should not exceed k steps. So,
we move the left iterator until our window size fits k steps.

Java
We could binary-search for l, but we will need a custom comparator.
Instead, we just advance l to keep the code short and simple.

TC : o(n)
SC : o(1)
 */
public class MaximumFruitsHarvestedAfterAtMostKSteps  {

    public static void main(String[] args) {
        int[][] fruits = new int[][]{
                {2,8},{6,3},{8,6}
        };
        System.out.println(new MaximumFruitsHarvestedAfterAtMostKSteps().maxTotalFruits(fruits,5,4));
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left =0, maxSum=0, currentSum=0;
        while(left<fruits.length && startPos-k> fruits[left][0]){
            left++;
        }
        for(int right = left;right<fruits.length && fruits[right][0] <= startPos+k ;right++){
            currentSum+=fruits[right][1];

            while(Math.min(((startPos-fruits[left][0])*2 + fruits[right][0]- startPos),
                    ((fruits[right][0]-startPos)*2 + startPos - fruits[left][0]))>k){
                currentSum-=fruits[left++][1];
            }

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
