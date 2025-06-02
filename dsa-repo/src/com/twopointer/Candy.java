package com.twopointer;

import java.util.Arrays;

/*
135. Candy

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.



Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

TC : o(n)
SC: o(n)

Explanation
-------------
Do it in two directions.
The first loop makes sure children with a higher rating get more candy than its left neighbor;
    the second loop makes sure children with a higher rating get more candy than its right neighbor.
 */
public class Candy {

    public static void main(String[] args) {
        int[] ratings = new int[]{1,2,2};
        System.out.println(new Candy().candy(ratings));
    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n<=1)
            return n;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                nums[i] = nums[i-1]+1;
        }
        for(int i=n-1;i>0;i--){
            if(ratings[i-1]>ratings[i])
                nums[i-1] = Math.max(nums[i-1], nums[i]+1);
        }
        int result =0;
        for(int num : nums){
            result += num;
        }
        return result;
    }
}
