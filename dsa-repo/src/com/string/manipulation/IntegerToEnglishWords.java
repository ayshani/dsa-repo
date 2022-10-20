package com.string.manipulation;
/*

Convert a non-negative integer num to its English words representation.

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
 */
public class IntegerToEnglishWords {

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(1234567));
    }
    String[] lessthan20 = new String[]{
            "","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",
            "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"
    };

    String[] tens = new String[]{
            "","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"
    };

    int billion = 1000000000, million = 1000000, thousand = 1000, hundred = 100;
    public String numberToWords(int n) {
        if(n==0)
            return "Zero";
        return backtrack(n).trim();
    }

    private String backtrack(int n){
        StringBuilder sb = new StringBuilder();
        if(n>=billion)
            sb.append(backtrack(n/billion)).append(" Billion ").append(backtrack(n%billion));
        else if(n>=million)
            sb.append(backtrack(n/million)).append(" Million ").append(backtrack(n%million));
        else if( n>=thousand)
            sb.append(backtrack(n/thousand)).append(" Thousand ").append(backtrack(n%thousand));
        else if(n>=hundred){
            sb.append(backtrack(n/hundred)).append(" Hundred ").append(backtrack(n%hundred));
        } else if(n>= 20){
            sb.append(tens[n/10]).append(" ").append(backtrack(n%10));
        } else {
            sb.append(lessthan20[n]);
        }

        return sb.toString().trim();
    }
}
