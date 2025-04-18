package com.string.manipulation;
/*

38. Count and Say

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each
substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit.
Finally, concatenate every said digit.

Example :
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

TC : o(n*n)
SC : o(1)
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(10));
    }
    public String countAndSay(int n) {
        if(n==1)
            return "1";

        String s = countAndSay(n-1);

        StringBuilder sb = new StringBuilder();
        int size = s.length();
        for(int i=0;i<size;i++){
            int count=1;
            while((i+1)<size && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
