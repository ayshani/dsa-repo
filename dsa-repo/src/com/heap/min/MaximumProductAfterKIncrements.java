package com.heap.min;

import java.util.PriorityQueue;

/*2233. Maximum Product After K Increments

You are given an array of non-negative integers nums and an integer k. In one operation, you may choose any element
from nums and increment it by 1.

Return the maximum product of nums after at most k operations. Since the answer may be very large, return it
modulo 109 + 7. Note that you should maximize the product before taking the modulo.



Example 1:

Input: nums = [0,4], k = 5
Output: 20
Explanation: Increment the first number 5 times.
Now nums = [5, 4], with a product of 5 * 4 = 20.
It can be shown that 20 is maximum product possible, so we return 20.
Note that there may be other ways to increment nums to have the maximum product.
Example 2:

Input: nums = [6,3,3,2], k = 2
Output: 216
Explanation: Increment the second number 1 time and increment the fourth number 1 time.
Now nums = [6, 4, 3, 3], with a product of 6 * 4 * 3 * 3 = 216.
It can be shown that 216 is maximum product possible, so we return 216.
Note that there may be other ways to increment nums to have the maximum product.

Logic
--------
We can increment minimum number in all k operations and take their product in end.
But why it works ?
Let's take two integers x and y and (x > y)

Now if you increment x by 1 then your product will be
product = (x + 1) * y = x * y + y

And if you increment y by 1 then your product will be
product = x * (y + 1) = x * y + x

As x * y is common in both, and as x > y so (x * y + x > x * y + y)
That's why it's always optimal to increment minimum number if you want to maximize their product
So, we do this for all k operations.

TC : o(nlogn)
SC : o(n)
 */
public class MaximumProductAfterKIncrements {

    public static void main(String[] args) {
        int[] nums = new int[]{6,3,3,2};
        int k = 2;
        System.out.println(new MaximumProductAfterKIncrements().maximumProduct(nums,k));
    }
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.offer(num);
        }

        for(int i=0;i<k;i++){
            pq.offer(pq.poll()+1);
        }

        int mod = 1000000007;
        long prod =1;
        while(!pq.isEmpty()){
            prod = (prod*pq.poll())%mod;
        }
        return (int)prod;
    }
}
