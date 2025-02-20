package com.string.manipulation;

import java.util.HashSet;
import java.util.Set;

/*
1980. Find Unique Binary String

Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length
n that does not appear in nums. If there are multiple answers, you may return any of them.

Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.
 */
public class FindUniqueBinaryString {

    public static void main(String[] args) {
        System.out.println(new FindUniqueBinaryString().findDifferentBinaryStringV1(new String[]{"01","00"}));
    }
    /*
    Cantor's diagonal argument is a proof in set theory.

    While we do not need to fully understand the proof and its consequences, this approach uses very similar ideas.

    We start by initializing the answer ans to an empty string. To build ans, we need to assign either
     "0" or "1" to each index i for indices 0 to n - 1. How do we assign them so ans is guaranteed to be
     different from every string in nums? We know that two strings are different, as long as they differ by
     at least one character. We can intentionally construct our ans based on this fact.

    For each index i, we will check the ith character of the ith
    string in ans. That is, we check curr = nums[i][i]. We then assign ans[i] to the opposite of curr.
    That is, if curr = "0", we assign ans[i] = "1". If curr = "1", we assign ans[i] = "0".

    What is the point of this strategy? ans will differ from every string in at least one position.
    More specifically:

    ans differs from nums[0] in nums[0][0].
    ans differs from nums[1] in nums[1][1].
    ans differs from nums[2] in nums[2][2].
    ...
    ans differs from nums[n - 1] in nums[n - 1][n - 1].
    Thus, it is guaranteed that ans does not appear in nums and is a valid answer.

    This strategy is applicable because both the length of ans and the length of each string in nums are larger
    than or equal to n, the number of strings in nums. Therefore, we can find one unique position for each string
    in nums.

    Algorithm

    Initialize the answer ans. Note that you should build the answer in an efficient manner according to the
    programming language you're using.
    Iterate i over the indices of nums:
    Set curr = nums[i][i].
    If curr = "0", add "1" to ans. Otherwise, add "0" to ans.
    Return ans.

    TC : o(n)
    SC: o(1)
     */
    public String findDifferentBinaryStringV1(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            char c = nums[i].charAt(i);
            sb.append(c=='0' ? '1' : '0');
        }
        return sb.toString();
    }

    /*
    this is a common approach of doing.
    1. convert the string s to integer.
    2. start from 0 and check if one gets missed in that set then return.

    TC : o(n^2)
    SC: o(n)
     */
    public String findDifferentBinaryStringV2(String[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(String num : nums){
            set.add(Integer.parseInt(num, 2));
        }

        int start =0, end = (int)Math.pow(2,n);
        while(start<end){
            if(set.contains(start))
                start++;
            else
                break;
        }

        String res = Integer.toBinaryString(start);
        if(res.length()<n)
            res = "0".repeat(n-res.length()) + res;
        return res;
    }
}
