package com.backtracking;
/*
1601. Maximum Number of Achievable Transfer Requests

We have n buildings numbered from 0 to n - 1. Each building has a number of employees. It's transfer season, and
some employees want to change the building they reside in.

You are given an array requests where requests[i] = [fromi, toi] represents an employee's request to transfer from
building fromi to building toi.

All buildings are full, so a list of requests is achievable only if for each building, the net change in employee
transfers is zero. This means the number of employees leaving is equal to the number of employees moving in. For
example if n = 3 and two employees are leaving building 0, one is leaving building 1, and one is leaving building
2, there should be two employees moving to building 0, one employee moving to building 1, and one employee moving
to building 2.

Return the maximum number of achievable requests.



Example 1:
Input: n = 5, requests = [[0,1],[1,0],[0,1],[1,2],[2,0],[3,4]]
Output: 5
Explantion: Let's see the requests:
From building 0 we have employees x and y and both want to move to building 1.
From building 1 we have employees a and b and they want to move to buildings 2 and 0 respectively.
From building 2 we have employee z and they want to move to building 0.
From building 3 we have employee c and they want to move to building 4.
From building 4 we don't have any requests.
We can achieve the requests of users x and b by swapping their places.
We can achieve the requests of users y, a and z by swapping the places in the 3 buildings.

Complexity Analysis

Here, N is the number of buildings, and M is the number of requests.

Time complexity: O(2^M * N)
We iterate over every two possibilities for each of the M requests; this is equal to 2^M possibilities. For the
leaf nodes, which are O(2^{M-1}), we will iterate over N buildings to check if the employee change is zero.
Therefor the total time complexity would be O(2^M * N)

Space complexity: O(N+M).

The array indegree is of size N, and there would be some stack space as well for the recursion.
The maximum number of active stack calls would equal M, i.e. O(N + M).

 */
public class MaximumNumberOfAchievableTransferRequests {


    public static void main(String[] args) {
        int[][] requests = new int[][]{
                {0,1},{1,0},{0,1},{1,2},{2,0},{3,4}
        };

        System.out.println(new MaximumNumberOfAchievableTransferRequests().maximumRequests(5,requests));
    }
    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        return helper(0, requests, indegree, n,0);
    }

    int helper(int start,int[][] requests,int[] indegree,int  n,int count){
        if(start==requests.length){
            for(int i=0;i<n;i++){
                // Check if all buildings have an in-degree of 0.
                if(indegree[i]!=0)
                    return 0;
            }
            return count;
        }

        //take
        // Consider this request, increment and decrement for the buildings involved
        indegree[requests[start][0]]--;
        indegree[requests[start][1]]++;
        // Move on to the next request and also increment the count of requests.
        int take = helper(start+1, requests, indegree, n,count+1);

        //Not take
        // Backtrack to the previous values to move back to the original state before the second recursion.
        indegree[requests[start][0]]++;
        indegree[requests[start][1]]--;
        // Ignore this request and move on to the next request without incrementing the count.
        int notTake = helper(start+1, requests, indegree, n,count);

        return Math.max(take,notTake);
    }
}
