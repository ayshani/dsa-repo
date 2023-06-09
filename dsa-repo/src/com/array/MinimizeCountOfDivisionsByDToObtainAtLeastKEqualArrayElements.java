package com.array;

import java.util.Collections;
import java.util.Vector;

/*
Minimize count of divisions by D to obtain at least K equal array elements
https://www.geeksforgeeks.org/minimize-count-of-divisions-by-d-to-obtain-at-least-k-equal-array-elements/

Given an array A[ ] of size N and two integers K and D, the task is to calculate the minimum possible number
of operations required to obtain at least K equal array elements. Each operation involves replacing an element
A[i] by A[i] / D. This operation can be performed any number of times.

Examples:

Input: N = 5, A[ ] = {1, 2, 3, 4, 5}, K = 3, D = 2
Output: 2
Explanation:
Step 1: Replace A[3] by A[3] / D, i.e. (4 / 2) = 2. Hence, the array modifies to {1, 2, 3, 2, 5}
Step 2: Replace A[4] by A[4] / D, i.e. (5 / 2) = 2. Hence, the array modifies to {1, 2, 3, 2, 2}
Hence, the modified array has K(= 3) equal elements.
Hence, the minimum number of operations required is 2.

Input: N = 4, A[ ] = {1, 2, 3, 6}, K = 2, D = 3
Output: 1
Explanation:
Replacing A[3] by A[3] / D, i.e. (6 / 3) = 2. Hence, the array modifies to {1, 2, 3, 2}.
Hence, the modified array has K(= 2) equal elements.
Hence, the minimum number of operations required is 1.

Naive Approach:
The simplest approach to solve the problem is to generate every possible subset of the given array and
perform the given operation on all elements of this subset. The number of operations required for each subset
will be equal to the size of the subset. For each subset, count the number of equal elements and check if count
is equal to K. If so, compare the then count with minimum moves obtained so far and update accordingly.
Finally, print the minimum moves.

Time Complexity: O(2^N *N)
Auxiliary Space: O(N)


Efficient Approach:
Follow the steps below to solve the problem:

Initialize a 2D vector V, in which, size of a row V[i] denotes the number of array elements that have been reduced
to A[i] and every element of the row denotes a count of divisions by D performed on an array element to obtain the
number i.
Traverse the array. For each element A[i], keep dividing it by D until it reduces to 0.
For each intermediate value of A[i] obtained in the above step, insert the number of divisions required into V[A[i]].
Once, the above steps are completed for the entire array, iterate over the array V[ ].
For each V[i], check if the size of V[i] ≥ K (at most K).
If V[i] ≥ K, it denotes that at least K elements in the array have been reduced to i. Sort V[i] and add the
first K values, i.e. the smallest K moves required to make K elements equal in the array.
Compare the sum of K moves with the minimum moves required and update accordingly.
Once the traversal of the array V[] is completed, print the minimum count of moves obtained finally.

Time Complexity: O(MlogM), where M is the maximum number taken
Auxiliary Space: O(M)

 */
public class MinimizeCountOfDivisionsByDToObtainAtLeastKEqualArrayElements {


    static int getMinimumMoves(int n, int k,
                               int d, int[] a)
    {
        int MAX = 100000;

        // Stores the number of moves
        // required to obtain respective
        // values from the given array
        Vector<Integer>[]v = new Vector[MAX];
        for(int i = 0; i < v.length; i++)
            v[i] = new Vector<Integer>();

        // Traverse the array
        for(int i = 0; i < n; i++)
        {
            int cnt = 0;

            // Insert 0 into V[a[i]] as
            // it is the initial state
            v[a[i]].add(0);

            while (a[i] > 0)
            {
                a[i] /= d;
                cnt++;

                // Insert the moves required
                // to obtain current a[i]
                v[a[i]].add(cnt);
            }
        }

        int ans = Integer.MAX_VALUE;

        // Traverse v[] to obtain
        // minimum count of moves
        for(int i = 0; i < MAX; i++)
        {

            // Check if there are at least
            // K equal elements for v[i]
            if (v[i].size() >= k)
            {
                int move = 0;

                Collections.sort(v[i]);

                // Add the sum of minimum K moves
                for(int j = 0; j < k; j++)
                {
                    move += v[i].get(j);
                }

                // Update answer
                ans = Math.min(ans, move);
            }
        }

        // Return the final answer
        return ans;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int N = 5, K = 3, D = 2;
        int []A = { 1, 2, 3, 4, 5 };

        System.out.print(getMinimumMoves(N, K, D, A));
    }
}
