package com.array;
/*
1608. Special Array With X Elements Greater Than or Equal X

You are given an array nums of non-negative integers. nums is considered special if there exists
a number x such that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special,
the value for x is unique.

Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.

Example 3:

Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values that are greater than or equal to 3.


Logic
-----
We are storing the count of elements <= X in a count map.
Then we are doing cumulative sum from backwards.
At any index if cumulative count is equal to index then that index is our answer.

This takes O(n) space and have Theta(n) time complexity.
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static void main(String[] args) {
        int[] nums = new int[]{0,4,3,0,4};

        System.out.println(new SpecialArrayWithXElementsGreaterThanOrEqualX().specialArray(nums));
    }
    public int specialArray(int[] nums) {
        int x = nums.length;
        int[] count = new int[x+1];

        for(int num : nums){
            if(num>= x)
                count[x]++;
            else
                count[num]++;
        }

        int res =0;
        for( int i=count.length-1;i>=0;i--){
            res+=count[i];
            if(res==i)
                return i;
        }

        return -1;
    }
}
