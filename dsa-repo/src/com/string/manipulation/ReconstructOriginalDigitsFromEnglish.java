package com.string.manipulation;
/*
423. Reconstruct Original Digits from English

Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.

Example 1:

Input: s = "owoztneoer"
Output: "012"

TC : o(n)
SC: o(1)
 */
public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits("fviefuro"));
    }
    public String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++; //7-6
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++;
            if (c == 'f') count[5]++; //5-4
            if (c == 'h') count[3]++; //3-8
            if (c == 'i') count[9]++; //9-8-5-6
            if (c == 'o') count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
