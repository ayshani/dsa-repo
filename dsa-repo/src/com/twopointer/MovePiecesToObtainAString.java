package com.twopointer;
/*
2337. Move Pieces to Obtain a String

You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R',
and '_' where:

The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank
    space directly to its left, and a piece 'R' can move to the right only
    if there is a blank space directly to its right.
The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
Return true if it is possible to obtain the string target by moving the pieces of the string start
    any number of times. Otherwise, return false.



Example 1:

Input: start = "_L__R__R_", target = "L______RR"
Output: true
Explanation: We can obtain the string target from start by doing the following moves:
- Move the first piece one step to the left, start becomes equal to "L___R__R_".
- Move the last piece one step to the right, start becomes equal to "L___R___R".
- Move the second piece three steps to the right, start becomes equal to "L______RR".
Since it is possible to get the string target from start, we return true.


I am ignoring all the empty _ charcater,

As soon as i encounter any character other then _ ,
Then the characters must be same,

if It is 'L'
then this condition must hold j>= i , if in target string it found at index i and , in st string it found at J
because we can move 'L' character to left , means left in st string ,
otherwise i should return false;

same with 'R'
then this condition must hold j<= i , if in target string it found at index i and , in st string it found at J
because we can move 'R' character to right ,means right in st string ,
otherwise i should return false;

Time complexityO(N)
because every time either i increase I , or J , or both

Space complexityO(1)
 */
public class MovePiecesToObtainAString {

    public static void main(String[] args) {
        System.out.println(new MovePiecesToObtainAString().canChange("R_L_", "__LR"));

    }
    public boolean canChange(String start, String target) {
        int startIndex =0, targetIndex =0;

        int n = target.length();
        while(startIndex<=n && targetIndex<=n){
            while(startIndex<n && start.charAt(startIndex)=='_')
                startIndex++;
            while(targetIndex<n && target.charAt(targetIndex)=='_')
                targetIndex++;

            if(startIndex== n || targetIndex==n )
                return startIndex==n && targetIndex==n;

            if(start.charAt(startIndex) !=target.charAt(targetIndex))
                return false;
            if(target.charAt(targetIndex)=='L'){
                if(startIndex< targetIndex)
                    return false;
            }

            if(target.charAt(targetIndex)=='R'){
                if(startIndex> targetIndex)
                    return false;
            }
            startIndex++;
            targetIndex++;
        }
        return true;
    }
}
