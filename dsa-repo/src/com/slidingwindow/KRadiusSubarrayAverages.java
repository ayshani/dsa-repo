package com.slidingwindow;

import java.util.Arrays;

/*
2090. K Radius Subarray Averages

You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all
elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or
after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at
index i.

The average of x elements is the sum of the x elements divided by x, using integer division. The integer division
truncates toward zero, which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75,
which truncates to 2.


Example 1:
Input: nums = [7,4,3,9,1,8,5,2,6], k = 3
Output: [-1,-1,-1,5,4,4,-1,-1,-1]
Explanation:
- avg[0], avg[1], and avg[2] are -1 because there are less than k elements before each index.
- The sum of the subarray centered at index 3 with radius 3 is: 7 + 4 + 3 + 9 + 1 + 8 + 5 = 37.
  Using integer division, avg[3] = 37 / 7 = 5.
- For the subarray centered at index 4, avg[4] = (4 + 3 + 9 + 1 + 8 + 5 + 2) / 7 = 4.
- For the subarray centered at index 5, avg[5] = (3 + 9 + 1 + 8 + 5 + 2 + 6) / 7 = 4.
- avg[6], avg[7], and avg[8] are -1 because there are less than k elements after each index.

TC : o(n)
SC: o(1) // ignoring the resultant array
 */
public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(new KRadiusSubarrayAverages().getAverages(nums,3)));
    }
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        if(n<k){
            Arrays.fill(res, -1);
            return res;
        }
        if(k==0){
            return nums;
        }

        for(int i=0;i<k;i++){
            res[i] = -1;
            res[n-1-i] = -1;
        }

        int start =0, count =0, index = k;
        long sum=0;
        int slidingWindowSize = 2*k+1;
        for(int end =0;end<n;end++){
            sum += nums[end];
            count++;
            if(count==slidingWindowSize){
                if(res[k]==-1)
                    break;
                long avg = sum/(slidingWindowSize);
                res[k++] = (int)avg;
                sum -= nums[start++];
                count--;
            }
        }
        return res;
    }

}
