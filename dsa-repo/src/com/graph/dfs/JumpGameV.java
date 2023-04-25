package com.graph.dfs;

import com.graph.bfs.JumpGameIV;

/*
1340. Jump Game V

Given an array of integers arr and an integer d. In one step you can jump from index i to index:

i + x where: i + x < arr.length and  0 < x <= d.
i - x where: i - x >= 0 and  0 < x <= d.
In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for
all indices k between i and j (More formally min(i, j) < k < max(i, j)).

You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
Output: 4
Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because 13 > 9.
You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
Similarly You cannot jump from index 3 to index 2 or index 1.


Explanation
--------------
For each index i, run search starting from i left and right up to d steps.
This way, we can easily detect if arr[j] is blocking further jumps.

So, we stop the search when we encounter j where arr[i] <= arr[j].

To prevent re-computations, we need to memoize max jumps for every index in dp.
TC : o(n*d)
SC: o(n)
 */
public class JumpGameV {

    public static void main(String[] args) {
        int d = 2, arr[] =  new int[]{6,4,14,6,8,13,9,7,10,6,12};
        System.out.println(new JumpGameV().maxJumps(arr,d));
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        Integer[] dp = new Integer[n];
        int res =1;

        for(int i=0;i<n;i++){
            res = Math.max(res,dfs(arr, n,d,i, dp));
        }
        return res;
    }

    private int dfs(int[] arr, int n, int d, int i, Integer[] dp ){
        if(dp[i]!=null)
            return dp[i];
        int res =1;
        for(int j= i+1; j<=Math.min(i+d, n-1) && arr[i]> arr[j]; j++){
            res = Math.max(res, 1+dfs(arr, n, d, j,dp));
        }
        for(int j= i-1; j>=Math.max(i-d, 0) && arr[i]> arr[j]; j--){
            res = Math.max(res, 1+dfs(arr, n, d, j,dp));
        }

        return dp[i] = res;
    }
}
