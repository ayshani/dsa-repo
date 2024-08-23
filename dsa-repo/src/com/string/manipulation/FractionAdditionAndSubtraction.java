package com.string.manipulation;

import java.util.stream.Stream;

/*
592. Fraction Addition and Subtraction

Given a string expression representing an expression of fraction addition and subtraction, return the calculation
result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format
of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.



Example 1:

Input: expression = "-1/2+1/2"
Output: "0/1"

TC : o(n*logn)
SC: o(n)
 */
public class FractionAdditionAndSubtraction {

    public static void main(String[] args) {
        System.out.println(new FractionAdditionAndSubtraction().fractionAddition("1/2+1/2+1/3"));
    }
    public String fractionAddition(String expression) {
        // splits input string into individual fractions
        String[] fraction = expression.split("(?=[-+])");
        String res = "0/1";
        for(String frac : fraction){
            // add all fractions together
            res = add(res, frac);
        }
        return res;
    }

    private String add(String frac1, String frac2){
        int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray();
        int[] f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();

        int nume = f1[0]*f2[1] + f1[1]*f2[0], denom = f1[1]*f2[1];
        String sign = "";
        if(nume<0){
            sign = "-";
            nume *= -1;
        }
        return sign + nume/gcd(nume,denom) + "/" + denom/gcd(nume,denom);
    }

    private int gcd(int x, int y){
        if(x==0 || y == 0){
            return x+y;
        }
        return gcd(y, x%y);
    }
}
