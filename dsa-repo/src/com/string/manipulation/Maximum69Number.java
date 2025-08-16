package com.string.manipulation;
/*
1323. Maximum 69 Number

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.


TC : o(n) : Since the input number num has up to most n digits
SC : o(n)
 */
public class Maximum69Number {

    public static void main(String[] args) {
        System.out.println(new Maximum69Number().maximum69Number(9669));
    }
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='6')
            {
                sb.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
