package com.array;
/*2929. Distribute Candies Among Children II

You are given two positive integers n and limit.

Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.



Example 1:

Input: n = 5, limit = 2
Output: 3
Explanation: There are 3 ways to distribute 5 candies such that no child gets more than 2 candies: (1, 2, 2), (2, 1, 2) and (2, 2, 1).

TC : O(min(limit,n)).
SC : o(1)
 */
public class DistributeCandiesAmongChildrenII {
    public static void main(String[] args) {
        System.out.println(new DistributeCandiesAmongChildrenII().distributeCandies(5,2));
    }
    public long distributeCandies(int n, int limit) {
        long ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }
}
