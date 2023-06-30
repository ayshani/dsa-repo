package com.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
496. Next Greater Element I

The next greater element of some element x in an array is the first greater element that is to the right of x in
the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater
element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.



Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

TC : o(n)
SC: o(n)
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,1,2}, nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(nums1,nums2)));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Map<Integer,Integer> nextGreater = computeNextGreaterElement(nums2);
        for(int i=0;i<n;i++){
            res[i] = nextGreater.getOrDefault(nums1[i],0);
        }
        return res;
    }

    private Map<Integer,Integer> computeNextGreaterElement(int[] nums){
        int n = nums.length;
        Map<Integer,Integer> res = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i= n-1;i>=0;i--){
            if(st.isEmpty()){
                res.put(nums[i],-1);
            } else {
                while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    res.put(nums[i],nums[st.peek()]);
                } else{
                    res.put(nums[i],-1);
                }
            }
            st.push(i);
        }
        return res;
    }
}
