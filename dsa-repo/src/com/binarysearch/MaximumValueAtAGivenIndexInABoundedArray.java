package com.binarysearch;
/*
1802. Maximum Value at a Given Index in a Bounded Array


You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed)
that satisfies the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.



Example 1:

Input: n = 4, index = 2,  maxSum = 6
Output: 2
Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].

Complexity Analysis
Time complexity: O(log(maxSum))
We set the searching space as [1, maxSum], thus it takes O(log(maxSum)) steps to finish the binary search.
At each step, we made some calculations that take O(1) time.

Space complexity: O(1)
Both the binary search and the getSum function take O(1) space.

 */
public class MaximumValueAtAGivenIndexInABoundedArray {

    public static void main(String[] args) {
        System.out.println(new MaximumValueAtAGivenIndexInABoundedArray().maxValue(4,2,6));
    }
    public int maxValue(int n, int index, int maxSum) {
        int left =1, right = maxSum;

        /*
        While left < right, get the middle index of the search space as mid = (left + right + 1) / 2,
        and check if getSum(index, mid) <= maxSum:
        If so, it means that nums[index] = mid is a valid value, we can go for the right half by setting left = mid.
        Otherwise, it means that mid is too large for nums[index], we shall go for the left half of the searching
        space by setting right = mid - 1.
        */
        while(left<right){
            int mid = (left +right +1)/2;
            if(getSum(index, n , mid)<= maxSum){
                left = mid;
            } else{
                right = mid-1;
            }
        }
        return left;
    }

    private long getSum(int index, int n, int value){

        long count =0;

        // On index's left:
        // If value > index, there are index + 1 numbers in the arithmetic sequence:
        // [value - index, ..., value - 1, value].
        // Otherwise, there are value numbers in the arithmetic sequence:
        // [1, 2, ..., value - 1, value], plus a sequence of length (index - value + 1) of 1s.
        if(value> index){
            count+= (long)(value+ value-index)*(index+1)/2;
        } else{
            count+= (long)(value+ 1)*value/2 + index-value+1;
        }

        // On index's right:
        // If value >= n - index, there are n - index numbers in the arithmetic sequence:
        // [value, value - 1, ..., value - n + 1 + index].
        // Otherwise, there are value numbers in the arithmetic sequence:
        // [value, value - 1, ..., 1], plus a sequence of length (n - index - value) of 1s.
        if(value>= n-index){
            count += (long) (value + value - n + 1 + index)*(n - index)/2;
        } else{
            count += (long)(value+1)*value/2 + n- index - value;
        }

        // as we included value two times above
        return count - value;
    }
}
