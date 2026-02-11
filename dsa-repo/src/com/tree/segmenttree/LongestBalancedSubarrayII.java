package com.tree.segmenttree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
3721. Longest Balanced Subarray II

You are given an integer array nums.

A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.

Return the length of the longest balanced subarray.



Example 1:

Input: nums = [2,5,4,3]

Output: 4

Explanation:

The longest balanced subarray is [2, 5, 4, 3].
It has 2 distinct even numbers [2, 4] and 2 distinct odd numbers [5, 3]. Thus, the answer is 4.


Intuition
The key idea is to convert the notion of “types of odd elements” and “types of even elements” from the problem
statement into a numerical form that can be efficiently processed by a data structure. Specifically, we map
each odd element to -1 and each even element to +1. Under this transformation, a subarray is balanced if and
only if the sum of its transformed values is 0.

After this transformation, the array becomes a difference array consisting only of -1 and +1. By computing the
prefix sum array, we observe that whenever a prefix sum equals 0, the corresponding prefix subarray is balanced.
More generally, for a fixed left boundary, the right boundary of the longest balanced subarray corresponds to the
rightmost position where the prefix sum is equal to the prefix sum at the left boundary.

Since the prefix sum changes by at most 1 at each step, it satisfies a discrete version of the intermediate value
theorem. This property allows us to use a segment tree to efficiently locate the rightmost occurrence of 0 in a
given range. The search works as follows:

Maintain both the minimum and maximum prefix sum values for each segment.
Check whether 0 lies within the range [min, max] of the right child. If it does, recurse into the right child.
Otherwise, recurse into the left child.
Because of the discrete intermediate value property, checking the minimum and maximum values is sufficient to
determine whether 0 exists in a segment, allowing each query to be completed in O(logn) time.

Next, we iterate over all possible left boundaries. Let the current left boundary be index i, and let the current
 maximum length of a balanced subarray be l. As an optimization, we start searching for the right boundary from
 index i+l, since any shorter subarray cannot improve the current answer.

The remaining challenge is handling the removal of the contribution of the element at the previous left boundary
as we move the left pointer forward.

Recall that in a difference array, a nonzero value at position i contributes to all prefix sums from position i
onward. For example, if the contribution at position 1 is -1, it decreases the values of S1, s2, ..., sn by 1.
More generally, if an element appears at positions p1 and p, its contribution at p1 affects the interval [p1,p2−1],
while the contribution at p2 affects the interval [p2,…].

[…,0,1,1,…,1 ∗ contributed by the first x,1,1,…,1 ∗ contributed by the second x,…]

Therefore, we record all positions where each element appears using a queue. When the left boundary moves forward,
we determine the interval over which the removed element contributes and subtract its effect from that interval.
Since this is a range update, it can be efficiently handled using the segment tree with lazy propagation.

Putting everything together, we first compute the prefix sums and record the occurrence positions of each element.
 Then, we iterate over all possible left boundaries, dynamically update the prefix sums using the segment tree,
 query the rightmost position where the prefix sum is 0, and update the global maximum length accordingly.

TC : o(nlogn)
SC: o(n)
 */
public class LongestBalancedSubarrayII {

    public static void main(String[] args) {
        System.out.println(new LongestBalancedSubarrayII().longestBalanced(new int[]{2,5,4,3}));
    }
    public int longestBalanced(int[] nums) {
        Map<Integer, Queue<Integer>> occurrences = new HashMap<>();

        int len = 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = sgn(nums[0]);
        occurrences.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1];
            Queue<Integer> occ = occurrences.computeIfAbsent(nums[i], k ->
                    new LinkedList<>()
            );
            if (occ.isEmpty()) {
                prefixSum[i] += sgn(nums[i]);
            }
            occ.add(i + 1);
        }

        SegmentTree seg = new SegmentTree(prefixSum);

        for (int i = 0; i < nums.length; i++) {
            len = Math.max(len, seg.findLast(i + len, 0) - i);

            int nextPos = nums.length + 1;
            occurrences.get(nums[i]).poll();
            if (!occurrences.get(nums[i]).isEmpty()) {
                nextPos = occurrences.get(nums[i]).peek();
            }

            seg.add(i + 1, nextPos - 1, -sgn(nums[i]));
        }

        return len;
    }

    private int sgn(int x) {
        return (x % 2) == 0 ? 1 : -1;
    }
}

    class LazyTag {

        int toAdd;

        LazyTag() {
        this.toAdd = 0;
        }

        LazyTag add(LazyTag other) {
        this.toAdd += other.toAdd;
        return this;
        }

        boolean hasTag() {
        return this.toAdd != 0;
        }

        void clear() {
        this.toAdd = 0;
        }
        }

class SegmentTreeNode {

    int minValue;
    int maxValue;
    LazyTag lazyTag;

    SegmentTreeNode() {
        this.minValue = 0;
        this.maxValue = 0;
        this.lazyTag = new LazyTag();
    }
}

class SegmentTree {

    private int n;
    private SegmentTreeNode[] tree;

    SegmentTree(int[] data) {
        this.n = data.length;
        this.tree = new SegmentTreeNode[this.n * 4 + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new SegmentTreeNode();
        }
        build(data, 1, this.n, 1);
    }

    void add(int l, int r, int val) {
        LazyTag tag = new LazyTag();
        tag.toAdd = val;
        update(l, r, tag, 1, this.n, 1);
    }

    int findLast(int start, int val) {
        if (start > this.n) {
            return -1;
        }
        return find(start, this.n, val, 1, this.n, 1);
    }

    private void applyTag(int i, LazyTag tag) {
        tree[i].minValue += tag.toAdd;
        tree[i].maxValue += tag.toAdd;
        tree[i].lazyTag.add(tag);
    }

    private void pushdown(int i) {
        if (tree[i].lazyTag.hasTag()) {
            LazyTag tag = new LazyTag();
            tag.toAdd = tree[i].lazyTag.toAdd;
            applyTag(i << 1, tag);
            applyTag((i << 1) | 1, tag);
            tree[i].lazyTag.clear();
        }
    }

    private void pushup(int i) {
        tree[i].minValue = Math.min(
                tree[i << 1].minValue,
                tree[(i << 1) | 1].minValue
        );
        tree[i].maxValue = Math.max(
                tree[i << 1].maxValue,
                tree[(i << 1) | 1].maxValue
        );
    }

    private void build(int[] data, int l, int r, int i) {
        if (l == r) {
            tree[i].minValue = tree[i].maxValue = data[l - 1];
            return;
        }

        int mid = l + ((r - l) >> 1);
        build(data, l, mid, i << 1);
        build(data, mid + 1, r, (i << 1) | 1);
        pushup(i);
    }

    private void update(
            int targetL,
            int targetR,
            LazyTag tag,
            int l,
            int r,
            int i
    ) {
        if (targetL <= l && r <= targetR) {
            applyTag(i, tag);
            return;
        }

        pushdown(i);
        int mid = l + ((r - l) >> 1);
        if (targetL <= mid) update(targetL, targetR, tag, l, mid, i << 1);
        if (targetR > mid) update(
                targetL,
                targetR,
                tag,
                mid + 1,
                r,
                (i << 1) | 1
        );
        pushup(i);
    }

    private int find(int targetL, int targetR, int val, int l, int r, int i) {
        if (tree[i].minValue > val || tree[i].maxValue < val) {
            return -1;
        }

        if (l == r) {
            return l;
        }

        pushdown(i);
        int mid = l + ((r - l) >> 1);

        if (targetR >= mid + 1) {
            int res = find(targetL, targetR, val, mid + 1, r, (i << 1) | 1);
            if (res != -1) return res;
        }

        if (l <= targetR && mid >= targetL) {
            return find(targetL, targetR, val, l, mid, i << 1);
        }

        return -1;
    }
}
