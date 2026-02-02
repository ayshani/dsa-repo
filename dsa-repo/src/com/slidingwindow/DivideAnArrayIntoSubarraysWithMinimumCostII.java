package com.slidingwindow;

import java.util.TreeSet;

/*
3013. Divide an Array Into Subarrays With Minimum Cost II

You are given a 0-indexed array of integers nums of length n, and two positive integers k and dist.

The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.

You need to divide nums into k disjoint contiguous subarrays, such that the difference between the starting index of the second subarray and the starting index of the kth subarray should be less than or equal to dist. In other words, if you divide nums into the subarrays nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)], then ik-1 - i1 <= dist.

Return the minimum possible sum of the cost of these subarrays.



Example 1:

Input: nums = [1,3,2,6,4,2], k = 3, dist = 3
Output: 5
Explanation: The best possible way to divide nums into 3 subarrays is: [1,3], [2,6,4], and [2]. This choice is valid because ik-1 - i1 is 5 - 2 = 3 which is equal to dist. The total cost is nums[0] + nums[2] + nums[5] which is 1 + 2 + 2 = 5.
It can be shown that there is no possible way to divide nums into 3 subarrays at a cost lower than 5.

TC : o(nlogn)
SC: o(n)
 */
public class DivideAnArrayIntoSubarraysWithMinimumCostII {

    public static void main(String[] args) {
        System.out.println(new DivideAnArrayIntoSubarraysWithMinimumCostII().minimumCost(
                new int[]{1,3,2,6,4,2}, 3,3
        ));
    }
    public long minimumCost(int[] nums, int k, int dist) {
        long result = Long.MAX_VALUE, windowSum =0l;
        int n = nums.length;
        TreeSet<Integer> using = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a-b : nums[a]-nums[b]);
        TreeSet<Integer> waiting = new TreeSet<>((a,b) -> nums[a] == nums[b] ? a-b : nums[a]-nums[b]);

        // Add dist+1 elements into set
        for(int i=1; i<=dist+1;i++){
            using.add(i);
            windowSum += nums[i];
        }

        // We need only k - 1 nums, move others to waiting set because we might need them in the future
        while(using.size() > k-1){
            int i= using.pollLast();
            windowSum -= nums[i];
            waiting.add(i);
        }
        // windowSum is the sum of k - 1 nums
        result = Math.min(result,windowSum);
        for(int i=1;i+dist+1<n;i++){

            // window slided so add new num to the waiting set
            waiting.add(i + dist + 1);

            // i is the left most num in the window, will be removed from window
            if(using.contains(i)){
                // i is one of the k - 1 num
                // remove and update windowSum
                // poll one num from waiting set and add
                windowSum -= nums[i];
                using.remove(i);
                int j = waiting.pollFirst();
                windowSum += nums[j];
                using.add(j);
            } else{
                // i is not one of the k - 1 num, it is in the waiting set
                // remove from waiting
                // check minimum num of the waiting set is lower than maximum num of the using set
                // If so, add to the using set, remove from waiting set
                // update window accordingly
                waiting.remove(i);
                int j1 = waiting.first(), j2 = using.last();
                if(nums[j1] < nums[j2]){
                    windowSum -= nums[j2];
                    using.remove(j2);
                    waiting.add(j2);

                    windowSum += nums[j1];
                    using.add(j1);
                    waiting.remove(j1);
                }
            }
            result = Math.min(result, windowSum);
        }

        return result + nums[0];
    }
}
