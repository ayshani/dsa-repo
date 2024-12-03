package com.string.manipulation;
/*
2109. Adding Spaces to a String

You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in
the original string where spaces will be added. Each space should be inserted before the character at the given index.

For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C',
which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
Return the modified string after the spaces have been added.



Example 1:

Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
Output: "Leetcode Helps Me Learn"
Explanation:
The indices 8, 13, and 15 correspond to the underlined characters in "LeetcodeHelpsMeLearn".
We then place spaces before those characters.

TC : o(n)
SC : o(1)
 */
public class AddingSpacesToAString {

    public static void main(String[] args) {
        int[] spaces = new int[]{8,13,15};

        System.out.println(new AddingSpacesToAString().addSpaces("LeetcodeHelpsMeLearn",spaces));
    }
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int idx =0,i=0;

        for(;i<s.length() && idx<spaces.length;i++){
            if(i!=spaces[idx]){
                sb.append(s.charAt(i));
            } else{
                sb.append(" ");
                idx++;
                i--;
            }
        }
        sb.append(s.substring(i));
        return sb.toString();
    }
}
