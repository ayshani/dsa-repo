package com.string.manipulation;
/*
541. Reverse String II

Given a string s and an integer k, reverse the first k characters for every 2k characters counting from
the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or
equal to k characters, then reverse the first k characters and leave the other as original.

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"

TC : o(n)
SC : o(n)
 */
public class ReverseStringII {

    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefg",2));
    }
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for(int start =0; start < arr.length; start+= 2*k){
            int i= start, j = Math.min(start+k-1, arr.length-1);

            while(i<j){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }
}
