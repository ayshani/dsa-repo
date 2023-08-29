package com.array;
/*
2833. Furthest Point From Origin

You are given a string moves of length n consisting only of characters 'L', 'R', and '_'. The string represents your
movement on a number line starting from the origin 0.

In the ith move, you can choose one of the following directions:

move to the left if moves[i] = 'L' or moves[i] = '_'
move to the right if moves[i] = 'R' or moves[i] = '_'
Return the distance from the origin of the furthest point you can get to after n moves.



Example 1:

Input: moves = "L_RL__R"
Output: 3
Explanation: The furthest point we can reach from the origin 0 is point -3 through the following sequence of
moves "LLRLLLR".

TC : o(n)
SC: o(1)
 */
public class FurthestPointFromOrigin {

    public static void main(String[] args) {
        System.out.println(new FurthestPointFromOrigin().furthestDistanceFromOrigin("_R__LL_"));
    }
    public int furthestDistanceFromOrigin(String moves) {
        int countL =0, countR =0, countSpace =0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='L')
                countL++;
            else if(moves.charAt(i)=='R')
                countR++;
            else
                countSpace++;
        }

        if(countL > countR)
            return countL + countSpace -countR;
        else
            return countR + countSpace -countL;
    }
}
