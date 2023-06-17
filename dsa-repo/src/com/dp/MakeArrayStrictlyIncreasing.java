package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1187. Make Array Strictly Increasing

Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make
arr1 strictly increasing.

In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment
arr1[i] = arr2[j].

If there is no way to make arr1 strictly increasing, return -1.



Example 1:

Input: arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
Output: 1
Explanation: Replace 5 with 2, then arr1 = [1, 2, 3, 6, 7].

Intuition
As we update arr1 from left to right, each element arr1[i] can be subjected to several potential operations:

If arr1[i] is less than or equal to arr1[i - 1], we must replace arr1[i] with the smallest value in
arr2 that is greater than arr1[i - 1], which we can identify using binary search. Otherwise, we can't make arr1
sorted.
If arr1[i] is greater than arr1[i - 1], we have two possible options:

1. Leave it unchanged and continue with the next index. No changes need to be made as arr1[i] is already greater
than arr1[i - 1].
2. Replace it with a smaller value (as doing so may make it easier to ensure that subsequent numbers are greater
than arr1[i]). We will use binary search to locate the smallest value greater than arr1[i - 1] in arr2.


Complexity Analysis
Let m,n be the length of arr1 and arr2.

Time complexity: O(m⋅n⋅logn)

Sorting arr2 takes O(nlogn) time.
To improve the efficiency of the algorithm, we use memoization and store the minimum number of operations to reach
each state (i, prev) in a hash map dp. There are m indices and at most n+1 possible prev as we might replace
arr[i] with any value in arr2. Each state is computed with a binary search over arr2, which takes O(logn).

Space complexity: O(m⋅n)

The maximum number of distinct states in dp is m⋅n.
 */
public class MakeArrayStrictlyIncreasing {
    Map<Pair, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,5,3,6,7}, arr2 = new int[]{1,3,2,4};
        System.out.println(new MakeArrayStrictlyIncreasing().makeArrayIncreasing(arr1,arr2));
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int answer = dfs(0,-1,arr1,arr2);
        return answer< 2_001 ? answer :-1;
    }

    private int dfs(int i, int prev, int[] arr1, int[] arr2){
        if(i==arr1.length)
            return 0;
        if(dp.containsKey(new Pair(i,prev)))
            return dp.get(new Pair(i,prev));

        int cost = 2_001;

        // If arr1[i] is already greater than prev, we can leave it be.
        if(arr1[i]>prev){
            cost = dfs(i+1, arr1[i],arr1,arr2);
        }

        // Find a replacement with the smallest value in arr2.
        int idx = binarySearch(arr2,prev);

        // replace arr[i] with the cost of 1 operation
        if(idx<arr2.length){
            cost = Math.min(cost, 1+ dfs(i+1,arr2[idx], arr1,arr2));
        }

        dp.put(new Pair(i,prev), cost);
        return cost;
    }

    private int binarySearch(int[] arr, int target){
        int l=0, r = arr.length;
        while(l<r){
            int mid = l+(r-l)/2;
            //Find the smallest value in arr2 that is greater than prev by binary search
            if(arr[mid]<=target)
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }

}

class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x =x;
        this.y =y;
    }
}
