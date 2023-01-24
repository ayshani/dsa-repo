package com.binarysearch;
/*
1760. Minimum Limit of Balls in a Bag

You are given an integer array nums where the ith bag contains nums[i] balls.
You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls.
For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Return the minimum possible penalty after performing the operations.



Example 1:

Input: nums = [9], maxOperations = 2
Output: 3
Explanation:
- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.

Intuition
Minimum possible penalty can be 1,
and max possible penalty can be eq to max element. This is the possible range of our answer.
If we have a helper function which tells if it is possible to get a certain penalty considering
the max number of operations allowed, we can perform binary search on above range to minimize the possible penalty.
helper functon
It calculates the total number of operations required to make every number less than or eq to the current assumed penalty.
If the total ops required is less than or equal to the given limit of maxOperations, it is possible.

TC : o(nlogn)
SC: o(1)
 */
public class MinimumLimitOfBallsInABag {
    public static void main(String[] args) {
        int[] nums = new int[]{2,4,8,2};
        System.out.println(new MinimumLimitOfBallsInABag().minimumSize(nums,4));
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int start =1;
        int end = nums[0];
        for(int i=1;i<nums.length;i++){
            end = Math.max( end, nums[i]);
        }
        int minPenalty = end;
        while(start<= end){
            int mid = start+(end-start)/2;
            if(isPossible(nums, mid, maxOperations)){
                minPenalty = mid;
                end = mid -1;
            } else{
                start = mid+1;
            }
        }

        return minPenalty;
    }

    private boolean isPossible(int[] nums, int mid, int maxOp){
        int requiredOperations =0;
        for(int num : nums){
            int minCut = num/mid;
            if(num%mid==0){
                minCut--;
            }
            requiredOperations += minCut;
        }

        return requiredOperations<= maxOp;
    }
}
