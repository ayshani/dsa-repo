package com.graph.unionfind;
/*
839. Similar String Groups

Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar,
but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that
"tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that
a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list strs of strings where every string in strs is an anagram of every other string in strs.
How many groups are there?

Example 1:

Input: strs = ["tars","rats","arts","star"]
Output: 2


Explanation:
To solve the problem, we can use a Union-Find data structure to keep track of the connected groups. We initialize
the Union-Find data structure with n nodes, where n is the number of strings in strs. We iterate over all pairs
of strings in strs, and for each pair, we check if they are similar using the isSimilar method. If two strings are
similar, we union their corresponding indices in the Union-Find data structure. After iterating over all pairs of
strings, the number of connected groups in the Union-Find data structure gives us the answer to the problem.

The isSimilar method checks if two strings a and b are similar. We do this by iterating over all positions of the
strings, and counting the number of positions where the characters are different. If the number of different positions
is greater than 2, the strings are not similar, and we return false. Otherwise, we return true. Note that we only
need to check up to 2 positions, since swapping more than 2 positions would require more than one swap, which is
not allowed in the problem.

The Union-Find data structure consists of an array parent of size n, where parent[i] stores the parent of the i-th
node. Initially, each node is its own parent, so parent[i] = i. The Union-Find data structure has two main operations:
find and union.

The find operation finds the parent of a node x. If parent[x] == x, then x is its own parent, and we return x.
Otherwise, x has a parent parent[x], and we recursively call find(parent[x]) to find the parent of x.

The union operation unions two nodes x and y. We first find the parent of x and the parent of y using the find
operation. If the parents are different, we set the parent of the parent of x to be the parent of y, i.e.,
parent[find(x)] = find(y). This effectively merges the two connected components that x and y belong to.
We also decrement the count of connected components.

The count method returns the number of connected components in the Union-Find data structure.

Time complexity:

The time complexity of the given solution is O(N^2 * L + N * alpha(N)), where N is the number of strings in the
input list strs, L is the maximum length of the strings, and alpha is the inverse Ackermann function, which is a
very slowly growing function and can be considered constant for practical purposes. The O(N^2 * L) term comes from
iterating over all pairs of strings and checking if they are similar using the isSimilar method, which has a time
complexity of O(L). The O(N * alpha(N)) term comes from the Union-Find data structure, which has a worst-case time
complexity of O(N * alpha(N)).

Space complexity:
The space complexity of the solution is O(N), which comes from the Union-Find data structure. Specifically, we need
an array of size N to store the parent of each node. Note that the isSimilar method and other auxiliary variables
used in the solution have constant space complexity.

 */
public class SimilarStringGroups {

    public static void main(String[] args) {
        String[] s = new String[]{"tars","rats","arts","star"};
        System.out.println(new SimilarStringGroups().numSimilarGroups(s));
    }
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i], strs[j]))
                    uf.union(i,j);
            }
        }
        return uf.count;
    }

    private boolean isSimilar(String a, String b){
        int diff =0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
                if(diff>2){
                    return false;
                }
            }
        }
        return true;
    }
}
