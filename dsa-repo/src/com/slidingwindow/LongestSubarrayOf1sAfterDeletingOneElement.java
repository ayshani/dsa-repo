package com.slidingwindow;
/*
1493. Longest Subarray of 1's After Deleting One Element

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array.
Return 0 if there is no such subarray.

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Logic
-------
As per description, we need to delete one element. If 0 is available, then it will be deleted,
else one 1 will be deleted.

loop over the array nums[]
keep track of the max range(j-i)
incase we got one element as 0, we decrement maxOperation.

if max Operation becomes negative i.e. when we get another 0,
we increment the starting position until max Operation again become positive.

TC : o(n)
SC : o(1)
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(new LongestSubarrayOf1sAfterDeletingOneElement().longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int res =0, i=0,j=0, k=1;
        for(j=0;j<nums.length;j++){
            if(nums[j]==0)
                k--;
            while(k<0){
                if(nums[i]==0)
                {
                    k++;
                }
                i++;
            }

            res = Math.max(res, j-i);
        }
        return res;
    }
}
