package com.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
2790. Maximum Number of Groups With Increasing Length


You are given a 0-indexed array usageLimits of length n.

Your task is to create groups using numbers from 0 to n - 1, ensuring that each number, i, is used no more than
usageLimits[i] times in total across all groups. You must also satisfy the following conditions:

Each group must consist of distinct numbers, meaning that no duplicate numbers are allowed within a single group.
Each group (except the first one) must have a length strictly greater than the previous group.
Return an integer denoting the maximum number of groups you can create while satisfying these conditions.



Example 1:

Input: usageLimits = [1,2,5]
Output: 3
Explanation: In this example, we can use 0 at most once, 1 at most twice, and 2 at most five times.
One way of creating the maximum number of groups while satisfying the conditions is:
Group 1 contains the number [2].
Group 2 contains the numbers [1,2].
Group 3 contains the numbers [0,1,2].

Intuition
If we can have k group,
we need at least 1 + 2 + ... + k elements.


Explanation
So we use A[i] to fill this pattern.

If currently we have k group and x availble elements,
we check if we can have the k + 1th group.
If x >= k + 1, we can fullfill the pattern,
and we can have the k + 1 group.
If x < k + 1, we need to wait more element to come in.


Complexity
Time O(nlogn)
Space O(n)

 */
public class MaximumNumberOfGroupsWithIncreasingLength {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfGroupsWithIncreasingLength()
                .maxIncreasingGroups(Arrays.asList(1,2,5)));
    }
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        long total =0;
        int  k =0;
        for(int limit : usageLimits){
            total += limit;
            if(total >= (k+1)*(k+2)/2)
                k++;
        }
        return k;
    }
}
