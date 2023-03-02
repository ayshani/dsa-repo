package com.string.manipulation;
/*
443. String Compression

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character
array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.



Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

TC : o(n)
SC : o(n)
 */
public class StringCompression {

    public static void main(String[] args) {
        char[] c = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(new StringCompression().compress(c));
    }
    public int compress(char[] chars) {
        char ch = chars[0];
        int total =0;
        String s = "";
        for(char i : chars){
            if(i==ch)
                total++;
            else{
                s +=ch;
                ch =i;
                if(total>1)
                    s += String.valueOf(total);
                total =1;
            }
        }
        if(total!=0){
            s+=ch;
            if(total>1)
                s += String.valueOf(total);
        }
        int len =0;
        for(char c : s.toCharArray()){
            chars[len++]=c;
        }
        return s.length();
    }
}
