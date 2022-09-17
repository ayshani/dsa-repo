package com.string.manipulation;
/*
2384. Largest Palindromic Number

You are given a string num consisting of digits only.

Return the largest palindromic integer (in the form of a string) that can be formed using digits taken from num.
It should not contain leading zeroes.

Notes:

You do not need to use all the digits of num, but you must use at least one digit.
The digits can be reordered.


Example 1:

Input: num = "444947137"
Output: "7449447"
Explanation:
Use the digits "4449477" from "444947137" to form the palindromic integer "7449447".
It can be shown that "7449447" is the largest palindromic integer that can be formed.

Explanation
Count the frequency of all digits in num
Check how many pair of 9 that we have:
If we have one pair of 9, we can make 9XXXXXX9, res = '99' now.
If we have two pairs of 9, we can make 99XXXX99, res = '9' now.
Continue check pairs for 8,7,6,5,4,3,2,1,0
Strip the leading 0 in res
Find the maximum digit left that can be used for the middle digit of palindromic number.
final result is res + mid + reversed(res)
For special input like 00, we need to return 0.

TC : o(n)
SC : o(1)

 */
public class LargestPalindromicNumber {

    public static void main(String[] args) {
        System.out.println(new LargestPalindromicNumber().largestPalindromic("00009"));
    }
    public String largestPalindromic(String num) {
        int[] arr = new int[10];
        StringBuilder sb = new StringBuilder();
        for(char c : num.toCharArray()){
            arr[c-'0']++;
        }

        int mid =-1;
        for(int i=9;i>=0;i--){
            if(arr[i]==0)
                continue;
            if(arr[i]%2==1)
                mid = Math.max(mid, i);

            if(i==0 && sb.length()==0)
                break;

            int t = arr[i]/2;
            while(t-->0)
                sb.append(i);
        }

        StringBuilder rev = new StringBuilder(sb).reverse();
        sb.append(rev);
        if(mid!=-1){
            sb.insert(sb.length()/2, mid);
        }

        return sb.length()==0 ? "0" : sb.toString();
    }
}
