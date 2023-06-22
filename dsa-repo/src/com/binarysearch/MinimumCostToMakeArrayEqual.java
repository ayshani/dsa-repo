package com.binarysearch;
/*
2448. Minimum Cost to Make Array Equal

You are given two 0-indexed arrays nums and cost consisting each of n positive integers.

You can do the following operation any number of times:

Increase or decrease any element of the array nums by 1.
The cost of doing one operation on the ith element is cost[i].

Return the minimum total cost such that all the elements of the array nums become equal.



Example 1:

Input: nums = [1,3,5,2], cost = [2,3,1,14]
Output: 8
Explanation: We can make all the elements equal to 2 in the following way:
- Increase the 0th element one time. The cost is 2.
- Decrease the 1st element one time. The cost is 3.
- Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
The total cost is 2 + 3 + 3 = 8.
It can be shown that we cannot make the array equal with a smaller cost.

Explanation
-----------------------
Assume the final equal values are x
the total cost function y = f(x) is a convex function
on the range of [min(A), max(A)].

To find the minimum value of f(x),
we can binary search x by comparing f(mid) and f(mid + 1).

If f(mid) <= f(mid + 1),
the minimum f(x) is on the left of mid,
where x <= mid

If f(mid) >= f(mid + 1),
the minimum f(x) is on the right of mid + 1,
where x >= mid.

Repeatly doing this while left < right,
until we find the minimum value and return it.

This method is known as trinary search,
if we check f(mid1) and f(mid2).


Complexity
Time O(nlog(a)), where a is the range of A[i]
Space O(1)
 */
public class MinimumCostToMakeArrayEqual {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2}, cost = new int[]{2,3,1,14};
        System.out.println(new MinimumCostToMakeArrayEqual().minCost(nums,cost));
    }
    public long minCost(int[] nums, int[] cost) {
        long left =1L, right = 1000000L;
        for(int num : nums){
            left = Math.min(num,left);
            right = Math.max(num, right);
        }

        long ans = 0;
        while(left<right){
            long mid = left+(right-left)/2;
            long y1 = findCost(nums, cost,mid);
            long y2 = findCost(nums, cost,mid+1);
            ans = Math.min(y1,y2);
            if(y1<y2){
                right = mid;
            } else{
                left = mid+1;
            }
        }
        return ans;
    }

    private long findCost(int[] nums,int[] cost,long x){
        long res = 0L;
        for(int i=0;i<nums.length;i++){
            res += Math.abs(nums[i]-x)*cost[i];
        }
        return res;
    }
}
