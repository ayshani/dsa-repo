package com.string.manipulation;
/*
880. Decoded String at Index

You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at
a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
Given an integer k, return the kth letter (1-indexed) in the decoded string.



Example 1:

Input: s = "leet2code3", k = 10
Output: "o"
Explanation: The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".

Explanation
--------------
We decode the string and N keeps the length of decoded string, until N >= K.
Then we go back from the decoding position.
If it's S[i] = d is a digit, then N = N / d before repeat and K = K % N is what we want.
If it's S[i] = c is a character, we return c if K == 0 or K == N


Complexity
Time O(N)
Space O(1)
 */
public class DecodedStringAtIndex {

    public static void main(String[] args) {
        System.out.println(new DecodedStringAtIndex().decodeAtIndex("leet2code3", 10));
    }
    public String decodeAtIndex(String s, int k) {
        int i;
        long N =0;
        // get the total character count till we exceed K
        for(i=0; N<k;i++){
            N = Character.isDigit(s.charAt(i)) ? N*(s.charAt(i)-'0') : N+1;
        }

        for(i-- ; i>0;i--){
            if(Character.isDigit(s.charAt(i))){
                N /= s.charAt(i)-'0';
                k %= N;
            } else{
                if(k %N ==0){
                    break;
                }
                N--;
            }
        }
        return Character.toString(s.charAt(i));
    }
}
