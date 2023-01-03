package com.string.manipulation;
/*
2129. Capitalize the Title

You are given a string title consisting of one or more words separated by a single space,
where each word consists of English letters. Capitalize the string by changing the capitalization
of each word such that:

If the length of the word is 1 or 2 letters, change all letters to lowercase.
Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
Return the capitalized title.



Example 1:

Input: title = "capiTalIze tHe titLe"
Output: "Capitalize The Title"
Explanation:
Since all the words have a length of at least 3, the first letter of each word is uppercase,
and the remaining letters are lowercase.

TC : o(n)
SC : o(1)
 */
public class CapitalizeTheTitle {

    public static void main(String[] args) {
        System.out.println(new CapitalizeTheTitle().capitalizeTitle("First leTTeR of EACH Word"));
    }
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<words.length;i++){
            String current = words[i];
            if(current.length()<3){
                words[i] = current.toLowerCase();
            }else{
                String newStr = String.valueOf(Character.toUpperCase(current.charAt(0)));
                newStr += current.substring(1).toLowerCase();
                words[i] = newStr;
            }

            result.append(words[i] +" ");
        }

        return String.valueOf(result).trim();
    }
}
