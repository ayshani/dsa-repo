package com.string.manipulation;
/*
345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "hello"
Output: "holle"

TC : o(n)
SC : o(n)
 */
public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("leetcode"));
    }
    public String reverseVowels(String s) {
        char[] a=s.toCharArray();
        int l=0,r=a.length-1;
        // for(char ac:a)
        //   System.out.println(ac);
        while(l<r){
            while(l<r){

                if(a[l]=='a' | a[l]=='e' | a[l]=='i' | a[l]=='o' | a[l]=='u'| a[l]=='A' | a[l]=='E' | a[l]=='I' | a[l]=='O' | a[l]=='U')
                    break;
                else
                    l++;
                // System.out.println(l+"******");
            }

            while(r>l){
                if(a[r]=='a' | a[r]=='e' | a[r]=='i' | a[r]=='o' | a[r]=='u' | a[r]=='A' | a[r]=='E' | a[r]=='I' | a[r]=='O' | a[r]=='U')
                    break;
                else
                    r--;
                //  System.out.println(r);
            }

            // System.out.println(r);
            if(l<r){
                char tmp=a[l];
                a[l]=a[r];
                a[r]=tmp;
                l++;
                r--;
            }
            // System.out.println(a);
        }
        return String.valueOf(a);
    }
}
