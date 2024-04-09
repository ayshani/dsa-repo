package com.graph.unionfind;
/*
1061. Lexicographically Smallest Equivalent String

You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab"
are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.



Example 1:

Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters
as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".

Complexity Analysis
--------------------
Here, N is the length of strings s1 and s2, M is the length of string base,
and ∣Σ∣ is the number of unique characters in s1 or s2, which is 26 for this problem.

Time complexity: O((N+M)log∣Σ∣).

We perform the union operation for all the N characters in the strings s1 and s2.
Since we didn't use union by size and only have the path compression,
the time complexity for the union operation would be equal to O(log∣Σ∣).
Also, we iterate over the characters in base and call the find() operations which costs O(Mlog∣Σ∣) in total.
Therefore the total time complexity equals O((N+M)log∣Σ∣).

Space complexity: O(∣Σ∣).

The only space needed is the list of size ∣Σ∣ representative to store the representatives,
and hence the total space complexity is constant.

Note: The strings s1 and s2, as per the problem description,
can only have lowercase English letters. Therefore, the time complexity of both solutions could
also be mentioned as O(N+M), and the space complexity as constant.


 */
public class LexicographicallySmallestEquivalentString {

    int[] representative = new int[26];

    public static void main(String[] args) {
        String s1 = "parker", s2 = "morris", base = "parser";

        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString(s1,s2,base));
    }

    // Returns the root representative of the component.
    int find(int x ){
        if(representative[x] == x){
            return x;
        }

        return representative[x] = find(representative[x]);
    }

    // Perform union if x and y aren't in the same component.
    void union(int x, int y){
        int fx = find(x), fy = find(y);

        if(fx==fy)
            return;

        // Make the smaller character representative.
        if(fx<fy){
            representative[fy] = fx;
        } else{
            representative[fx] = fy;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Make each character representative of itself.
        for(int i=0;i<26;i++){
            representative[i] = i;
        }

        // Perform union merge for all the edges.
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i) -'a', s2.charAt(i)-'a');
        }

        StringBuilder ans = new StringBuilder();
        // Create the answer string with final mappings.
        for(int i=0;i<baseStr.length();i++){
            ans.append((char) (find(baseStr.charAt(i) - 'a') + 'a'));
        }

        return ans.toString();
    }
}
