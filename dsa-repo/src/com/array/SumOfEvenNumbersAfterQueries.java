package com.array;

import java.util.Arrays;

/*
985. Sum of Even Numbers After Queries

You are given an integer array nums and an array queries where queries[i] = [vali, indexi].

For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.

Return an integer array answer where answer[i] is the answer to the ith query.



Example 1:

Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: At the beginning, the array is [1,2,3,4].
After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

Intuition and Algorithm

Let's try to maintain S, the sum of the array throughout one query operation.

When acting on an array element A[index], the rest of the values of A remain the same.
Let's remove A[index] from S if it is even, then add A[index] + val back (if it is even.)

Here are some examples:

If we have A = [2,2,2,2,2], S = 10, and we do A[0] += 4: we will update S -= 2, then S += 6.
At the end, we will have A = [6,2,2,2,2] and S = 14.

If we have A = [1,2,2,2,2], S = 8, and we do A[0] += 3: we will skip updating S (since A[0] is odd),
then S += 4. At the end, we will have A = [4,2,2,2,2] and S = 12.

If we have A = [2,2,2,2,2], S = 10 and we do A[0] += 1: we will update S -= 2,
then skip updating S (since A[0] + 1 is odd.) At the end, we will have A = [3,2,2,2,2] and S = 8.

If we have A = [1,2,2,2,2], S = 8 and we do A[0] += 2: we will skip updating S (since A[0] is odd),
then skip updating S again (since A[0] + 2 is odd.) At the end, we will have A = [3,2,2,2,2] and S = 8.

Time Complexity: O(N+Q), where N is the length of A and Q is the number of queries.

Space Complexity: O(Q), though we only allocate O(1) additional space.
 */
public class SumOfEvenNumbersAfterQueries {

    public static void main(String[] args) {
        int[] nums =  new int[]{1,2,3,4};
        int[][] queries = new int[][]{
                {1,0},{-3,1},{-4,0},{2,3}
        };

        int[] res = new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(nums,queries);

        Arrays.stream(res).forEach(ele -> System.out.print(ele + " "));
    }
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum =0;
        for(int num : nums)
        {
            if(num%2==0)
                sum+=num;
        }

        int[] ans = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int val = queries[i][0], index = queries[i][1];
            if(nums[index]%2==0)
                sum-=nums[index];
            nums[index]+=val;
            if(nums[index]%2==0)
                sum+=nums[index];

            ans[i] = sum;
        }

        return ans;
    }
}
