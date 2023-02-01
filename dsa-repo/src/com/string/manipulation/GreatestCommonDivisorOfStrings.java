package com.string.manipulation;
/*
1071. Greatest Common Divisor of Strings

For two strings s and t, we say "t divides s" if and only if s = t + ... + t
(i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Complexity Analysis
Let m,n be the lengthes of the two input strings str1 and str2.

Time complexity: O(m+n)

We need to compare the two concatenations of length O(m+n), it takes O(m+n) time.
We calculate the GCD using binary Euclidean algorithm, it takes log(m⋅n) time.
To sum up, the overall time complexity is O(m+n).
Space complexity: O(m+n) We need to compare the two concatenations of length O(m+n).
 */
public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("ABABAB","AB"));
    }
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        /*
        Since both strings contains multiples of the identical segment base,
        their concatenation must be consistent, regardless of the order (str1 + str2 = str2 + str1).
        */
        if(!(str1+str2).equals(str2+str1))
            return "";

        //Get the GCD gcdLength of the two lengths of str1 and str2
        int gcdLength = gcd(m,n);

        //Return the prefix string with a length of gcdLength of either str1 or str2 as the answer.
        return str1.substring(0,gcdLength);
    }

    private int gcd(int x, int y){
        if(y==0)
            return x;
        return gcd(y,x%y);
    }
}
