package com.binarysearch;

import java.util.Arrays;

/*
1838. Frequency of the Most Frequent Element
The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and
increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.



Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.

TC : o(nlogn)
SC: o(1)
 */
public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,4}, k = 5;
        System.out.println(new FrequencyOfTheMostFrequentElement().maxFrequency(nums,k));
    }
    public int maxFrequency(int[] nums, int k) {
        int low = 1, high = nums.length, ans =0;

        Arrays.sort(nums);
        while(low<=high){
            int mid = low+(high-low)/2;

            if(canIncrement(nums,mid,k)){
                ans = mid;
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return ans;
    }

    private boolean canIncrement(int[] nums,int mid, int k){
        long sum =0;
        for(int i=0;i<mid-1;i++){
            sum += nums[i];
        }

        for(int i=0,j=mid-1;j<nums.length; i++,j++){
            sum += nums[j];
            long need = 1L * nums[j]* mid;
            if(need - sum <=k)
                return true;
            sum -= nums[i];
        }
        return false;
    }
}
