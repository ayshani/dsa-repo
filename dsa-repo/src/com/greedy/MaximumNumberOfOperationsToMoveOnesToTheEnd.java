package com.greedy;
/*
3228. Maximum Number of Operations to Move Ones to the End

You are given a binary string s.

You can perform the following operation on the string any number of times:

Choose any index i from the string where i + 1 < s.length such that s[i] == '1' and s[i + 1] == '0'.
Move the character s[i] to the right until it reaches the end of the string or another '1'. For example, for s = "010010", if we choose i = 1, the resulting string will be s = "000110".
Return the maximum number of operations that you can perform.



Example 1:

Input: s = "1001101"

Output: 4

Explanation:

We can perform the following operations:

Choose index i = 0. The resulting string is s = "0011101".
Choose index i = 4. The resulting string is s = "0011011".
Choose index i = 3. The resulting string is s = "0010111".
Choose index i = 2. The resulting string is s = "0001111".

The algorithm logic is as follows:

Traverse the string s from left to right. For each segment of consecutive 0s, add the count of 1s that appear
before the first 0 in this segment to the answer, since all those previous 1s contribute one operation each.

If the current character is 1, increment the counter countOne by 1, indicating that there is one more 1 that
can potentially be blocked later.

After completing the traversal, return the final answer.

TC : o(n)
SC: o(1)
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfOperationsToMoveOnesToTheEnd().maxOperations("1001101"));
    }
    public int maxOperations(String s) {
        int count =0, ans =0, i =0;
        while( i < s.length()){
            if(s.charAt(i)== '0'){
                while(i+1<s.length() && s.charAt(i+1)=='0'){
                    i++;
                }
                ans += count;
            } else{
                count++;
            }
            i++;
        }
        return ans;
    }
}
