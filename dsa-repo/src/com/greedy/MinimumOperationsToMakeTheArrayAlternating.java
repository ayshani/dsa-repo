package com.greedy;

import java.util.ArrayList;
import java.util.List;

/*
2170. Minimum Operations to Make the Array Alternating

You are given a 0-indexed array nums consisting of n positive integers.

The array nums is called alternating if:

nums[i - 2] == nums[i], where 2 <= i <= n - 1.
nums[i - 1] != nums[i], where 1 <= i <= n - 1.
In one operation, you can choose an index i and change nums[i] into any positive integer.

Return the minimum number of operations required to make the array alternating.



Example 1:

Input: nums = [3,1,3,2,4,3]
Output: 3
Explanation:
One way to make the array alternating is by converting it to [3,1,3,1,3,1].
The number of operations required in this case is 3.
It can be proven that it is not possible to make the array alternating in less than 3 operations.

TC : o(n)
SC : o(n)
 */
public class MinimumOperationsToMakeTheArrayAlternating {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,2,4,3};
        System.out.println(new MinimumOperationsToMakeTheArrayAlternating().minimumOperations(nums));
    }
    public int minimumOperations(int[] nums) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }

        int[] evenMax = getMax(even.toArray(new Integer[0]));
        int[] oddMax = getMax(odd.toArray(new Integer[0]));

        if(evenMax[0] != oddMax[0]){
            return nums.length - (evenMax[1]+oddMax[1]);
        } else{
            return nums.length - Math.max(evenMax[1]+oddMax[2], evenMax[2]+oddMax[1]);
        }
    }

    private int[] getMax(Integer[] arr){
        int first =0, second =0;
        int[] freq = new int[100005];

        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
            if(freq[arr[i]]>= freq[first]){
                if(first != arr[i])
                    second = first;
                first = arr[i];
            } else if(freq[arr[i]] > freq[second]){
                second = arr[i];
            }
        }

        return new int[]{first, freq[first], freq[second]};
    }
}
