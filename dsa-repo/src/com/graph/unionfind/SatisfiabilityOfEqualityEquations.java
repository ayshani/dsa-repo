package com.graph.unionfind;
/*
990. Satisfiability of Equality Equations

You are given an array of strings equations that represent relationships between variables where each
string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".
Here, xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations,
or false otherwise.

Example 1:

Input: equations = ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
Example 2:

Input: equations = ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.

Intuition:
---------
We have 26 nodes in the graph.
All "==" equations actually represent the connection in the graph.
The connected nodes should be in the same color/union/set.

Then we check all inequations.
Two inequal nodes should be in the different color/union/set.

Explanation
-----------
We can solve this problem by DFS or Union Find.

Firt pass all "==" equations.
Union equal letters together
Now we know which letters must equal to the others.

Second pass all "!=" inequations,
Check if there are any contradict happens.

Time Complexity:
--------
Union Find Operation, amortized O(1)
First pass all equations, O(N)
Second pass all inequations, O(N)

Overall O(N)
 */
public class SatisfiabilityOfEqualityEquations {
    int[] unionFind  = new int[26];

    public static void main(String[] args) {
        String[] equations = new String[]{"a==b","b!=a"};
        System.out.println(new SatisfiabilityOfEqualityEquations().equationsPossible(equations));
    }
    public boolean equationsPossible(String[] equations) {
        for(int i=0;i<26;i++)
        {
            unionFind[i]=i;
        }

        for(String equation : equations){
            if(equation.charAt(1)=='='){
                unionFind[find(equation.charAt(0)-'a')] = find(equation.charAt(3)-'a');
            }
        }

        for(String equation : equations){
            if(equation.charAt(1)=='!' && find(equation.charAt(0)-'a') == find(equation.charAt(3)-'a')){
                return false;
            }
        }

        return true;

    }

    private int find(int x){
        if(x!=unionFind[x])
        {
            unionFind[x] = find(unionFind[x]);
        }
        return unionFind[x];
    }
}
