package com.string.manipulation;
/*
 838. Push Dominoes

There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously
push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly,
the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a
falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.

Logic
------
We can calculate the net force applied on every domino. The forces we care about are how close a domino is
to a leftward 'R', and to a rightward 'L': the closer we are, the stronger the force.

Algorithm

Scanning from left to right, our force decays by 1 every iteration, and resets to N if we meet an 'R',
so that force[i] is higher (than force[j]) if and only if dominoes[i] is closer (looking leftward)
to 'R' (than dominoes[j]).

Similarly, scanning from right to left, we can find the force going rightward (closeness to 'L').

For some domino answer[i], if the forces are equal, then the answer is '.'. Otherwise, the answer is
implied by whichever force is stronger.

Example

Here is a worked example on the string S = 'R.R...L':
We find the force going from left to right is [7, 6, 7, 6, 5, 4, 0].
The force going from right to left is [0, 0, 0, -4, -5, -6, -7].
Combining them (taking their vector addition), the combined force is [7, 6, 7, 2, 0, -2, -7],
for a final answer of RRRR.LL.

TC : o(n)
SC : o(n)
 */
public class PushDominoes {
    public static void main(String[] args) {
        System.out.println(new PushDominoes().pushDominoes(".L.R...LR..L.."));
    }
    public String pushDominoes(String dominoes) {
        char[] A = dominoes.toCharArray();
        int n = dominoes.length();
        int[] forces = new int[n];

        // Pouplate force from left to Right
        // i.e. force will be R
        int force =0;
        for(int i=0;i<n;i++){
            if(A[i]=='R')
                force=n;
            else if(A[i]=='L')
                force =0;
            else
                force = Math.max(force-1,0);
            forces[i]+=force;
        }

        // Pouplate force from Right to left
        // i.e. force will be L
        force =0;
        for(int i=n-1;i>=0;i--){
            if(A[i]=='R')
                force=0;
            else if(A[i]=='L')
                force =n;
            else
                force = Math.max(force-1,0);
            forces[i]-=force;
        }

        StringBuilder sb = new StringBuilder();
        for(int f : forces){
            sb.append(f>0 ? 'R' : f<0 ? 'L' : '.');
        }

        return sb.toString();
    }

}
