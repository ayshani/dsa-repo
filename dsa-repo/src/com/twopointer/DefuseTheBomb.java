package com.twopointer;

import java.util.Arrays;

/*
1652. Defuse the Bomb

You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array
code of length of n and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.
As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!



Example 1:

Input: code = [5,7,1,4], k = 3
Output: [12,10,16,13]
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is
[7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

TC : o(n)
SC : o(n)

 */
public class DefuseTheBomb {

    public static void main(String[] args) {
        int[] code = new int[]{5,7,1,4};
        int k =3;
        int[] res = new DefuseTheBomb().decrypt(code,k);
        Arrays.stream(res).forEach(e-> System.out.print(e+ " "));
    }
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k==0)
            return res;
        int start =1, end = k;
        if(k<0){
            k=-k;
            start = n-k;
            end = n-1;
        }
        int sum =0;
        for(int i=start ;i<=end;i++){
            sum+=code[i];
        }

        for(int i=0;i<n;i++){
            res[i] = sum;
            sum-=code[(start++)%n];
            sum+=code[(++end)%n];
        }

        return res;
    }
}
