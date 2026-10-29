package com.tree;

import java.util.ArrayList;
import java.util.List;

/*
3841. Palindromic Path Queries in a Tree

You are given an undirected tree with n nodes labeled 0 to n - 1. This is represented by a 2D array edges of length n - 1, where edges[i] = [ui, vi] indicates an undirected edge between nodes ui and vi.

You are also given a string s of length n consisting of lowercase English letters, where s[i] represents the character assigned to node i.

You are also given a string array queries, where each queries[i] is either:

"update ui c": Change the character at node ui to c. Formally, update s[ui] = c.
"query ui vi": Determine whether the string formed by the characters on the unique path from ui to vi (inclusive) can be rearranged into a palindrome.
Return a boolean array answer, where answer[j] is true if the jth query of type "query ui vi"​​​​​​​ can be rearranged into a palindrome, and false otherwise.



Example 1:

Input: n = 3, edges = [[0,1],[1,2]], s = "aac", queries = ["query 0 2","update 1 b","query 0 2"]

Output: [true,false]

Explanation:

"query 0 2": Path 0 → 1 → 2 gives "aac", which can be rearranged to form "aca", a palindrome. Thus, answer[0] = true.
"update 1 b": Update node 1 to 'b', now s = "abc".
"query 0 2": Path characters are "abc", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.
Thus, answer = [true, false].

TC : O((n+q)logn).
SC : o(nlogn)
 */
public class PalindromicPathQueriesInATree {

    public static void main(String[] args) {
        System.out.println(new PalindromicPathQueriesInATree().palindromePath(
                3, new int[][]{{0,1},{1,2}}, "aac",new String[]{"query 0 2","update 1 b","query 0 2"}
        ));
    }
    private List<List<Integer>> g;
    private int[][] fa;
    private int[] dep;
    private int[] l;
    private int[] r;
    private int timer;
    private int LOG;

    public List<Boolean> palindromePath(
            int n,
            int[][] edges,
            String s,
            String[] queries
    ) {
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        LOG = 32 - Integer.numberOfLeadingZeros(n);
        fa = new int[n][LOG];
        dep = new int[n];
        l = new int[n];
        r = new int[n];
        timer = 0;

        dfs(0, 0);

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                fa[i][j] = fa[fa[i][j - 1]][j - 1];
            }
        }

        BITree bit = new BITree(n + 1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            bit.updateRange(l[i], r[i], 1 << (chars[i] - 'a'));
        }

        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                bit.updateRange(
                        l[u],
                        r[u],
                        (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'))
                );
                chars[u] = c;
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int w = lca(u, v);
                int mask =
                        bit.query(l[u]) ^ bit.query(l[v]) ^ (1 << (chars[w] - 'a'));
                ans.add(Integer.bitCount(mask) <= 1);
            }
        }
        return ans;
    }

    private void dfs(int u, int p) {
        l[u] = ++timer;
        fa[u][0] = p;
        for (int v : g.get(u)) {
            if (v == p) {
                continue;
            }
            dep[v] = dep[u] + 1;
            dfs(v, u);
        }
        r[u] = timer;
    }

    private int lca(int u, int v) {
        if (dep[u] < dep[v]) {
            int t = u;
            u = v;
            v = t;
        }
        int diff = dep[u] - dep[v];
        for (int i = 0; i < LOG; i++) {
            if (((diff >> i) & 1) == 1) {
                u = fa[u][i];
            }
        }
        if (u == v) {
            return u;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (fa[u][i] != fa[v][i]) {
                u = fa[u][i];
                v = fa[v][i];
            }
        }
        return fa[u][0];
    }
}


class BITree {

    private int[] tree;
    private int n;

    public BITree(int _n) {
        n = _n;
        tree = new int[_n + 1];
    }

    private static int lowbit(int x) {
        return x & -x;
    }

    public void update(int x, int v) {
        while (x <= n) {
            tree[x] ^= v;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int ret = 0;
        while (x > 0) {
            ret ^= tree[x];
            x -= lowbit(x);
        }
        return ret;
    }

    public void updateRange(int l, int r, int v) {
        update(l, v);
        update(r + 1, v);
    }
}