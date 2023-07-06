package com.string.manipulation;
/*
917. Reverse Only Letters

Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.



Example 1:

Input: s = "ab-cd"
Output: "dc-ba"

TC : o(n)
SC: o(n)
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
    public String reverseOnlyLetters(String s) {
        char[] ch = s.toCharArray();

        int left =0, right = s.length()-1;
        while(left<right){
            if(!Character.isLetter(ch[left]))
                left++;
            if(!Character.isLetter(ch[right]))
                right--;
            if(Character.isLetter(ch[left]) && Character.isLetter(ch[right])){
                char temp = ch[left];
                ch[left]= ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }

        return String.valueOf(ch);
    }
}
