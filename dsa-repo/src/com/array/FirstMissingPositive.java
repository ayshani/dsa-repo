package com.array;
/*
41. First Missing Positive

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.



Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Intuition
If no number is missing from the array and all the numbers are placed in non-decreasing order,
then an element n will be at the (n-1)th index. Therefore, if we were to place all the elements
in their "correct" position, we can quickly infer the missing number as its index would not by one less than its value.

Approach
Check if a number is at its "correct" position by subtracting one from it and comparing it with its index.
If they aren't equal, swap the number with number present at its (value-1)th index.
Finally, decrement i by one to check if the number that it is swapped with is at its correct position.

Complexity
Time complexity: O(n)
Space complexity: O(1)
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++){
            // get current element
            int element = nums[i];

            // check if the element is in range ie 1-n
            if(element>0 && element <=n){
                // if it's in range, the position will be 1 less than its value
                int position = element -1;

                // check if nums[i] is in its correct place ie i-1 place
                // if not swap ith num with position- num
                if(nums[position]!= nums[i]){
                    int temp = nums[position];
                    nums[position] = nums[i];
                    nums[i] = temp;

                    //decrement i by one to check if the number that it is swapped with is at its correct position.
                    i--;
                }
            }
        }

        for(int i=0;i<n;i++){
            // checking if number is in its "correct" position
            if(nums[i]!= i+1)
                return i+1;
        }
        return n+1;
    }
}
