package com.binarysearch;
/*
1539. Kth Missing Positive Number

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Logic
------
Explanation
Assume the final result is x,
And there are m number not missing in the range of [1, x].
Binary search the m in range [0, A.size()].

If there are m number not missing,
that is A[0], A[1] .. A[m-1],
the number of missing under A[m] is A[m] - 1 - m.

If A[m] - 1 - m < k, m is too small, we update left = m.
If A[m] - 1 - m >= k, m is big enough, we update right = m.

Note that, we exit the while loop, l = r,
which equals to the number of missing number used.
So the Kth positive number will be l + k.


Complexity
Time O(logN)
Space O(1)
 */
public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] ar = new int[]{
                2,3,4,7,11
        };

        System.out.println(new KthMissingPositiveNumber().findKthPositive(ar,5));

    }
    public int findKthPositive(int[] arr, int k) {
        int l =0,r = arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] - 1 - mid <k)
                l =mid +1;
            else
                r = mid;
        }

        return l+k;
    }
}
