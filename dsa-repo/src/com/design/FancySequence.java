package com.design;

import java.util.ArrayList;
import java.util.List;

/*
1622. Fancy Sequence

Write an API that generates fancy sequences using the append, addAll, and multAll operations.

Implement the Fancy class:

Fancy() Initializes the object with an empty sequence.
void append(val) Appends an integer val to the end of the sequence.
void addAll(inc) Increments all existing values in the sequence by an integer inc.
void multAll(m) Multiplies all existing values in the sequence by an integer m.
int getIndex(idx) Gets the current value at index idx (0-indexed) of the sequence modulo 109 + 7. If the index is greater or equal than the length of the sequence, return -1.


Example 1:

Input
["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
Output
[null, null, null, null, null, 10, null, null, null, 26, 34, 20]

Explanation
Fancy fancy = new Fancy();
fancy.append(2);   // fancy sequence: [2]
fancy.addAll(3);   // fancy sequence: [2+3] -> [5]
fancy.append(7);   // fancy sequence: [5, 7]
fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14]
fancy.getIndex(0); // return 10
fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17]
fancy.append(10);  // fancy sequence: [13, 17, 10]
fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
fancy.getIndex(0); // return 26
fancy.getIndex(1); // return 34
fancy.getIndex(2); // return 20


 */
public class FancySequence {
    public static void main(String[] args) {
        Fancy fancy = new Fancy();
        fancy.append(2);   // fancy sequence: [2]
        fancy.addAll(3);   // fancy sequence: [2+3] -> [5]
        fancy.append(7);   // fancy sequence: [5, 7]
        fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14]
        System.out.println(fancy.getIndex(0)); // return 10
        fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17]
        fancy.append(10);  // fancy sequence: [13, 17, 10]
        fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
        System.out.println(fancy.getIndex(0)); // return 26
        System.out.println(fancy.getIndex(1)); // return 34
        System.out.println(fancy.getIndex(2)); // return 20
    }
}

class Fancy {

    static final int MOD = 1000000007;
    List<Integer> v;
    List<Integer> a;
    List<Integer> b;

    public Fancy() {
        v = new ArrayList<Integer>();
        a = new ArrayList<Integer>();
        b = new ArrayList<Integer>();
        a.add(1);
        b.add(0);
    }

    public void append(int val) {
        v.add(val);
        a.add(a.get(a.size() - 1));
        b.add(b.get(b.size() - 1));
    }

    public void addAll(int inc) {
        int bLastIndex = b.size() - 1;
        int bLast = b.get(bLastIndex);
        bLast = (bLast + inc) % MOD;
        b.set(bLastIndex, bLast);
    }

    public void multAll(int m) {
        int aLastIndex = a.size() - 1, bLastIndex = b.size() - 1;
        int aLast = (int) (((long) a.get(aLastIndex) * m) % MOD);
        a.set(aLastIndex, aLast);
        int bLast = (int) (((long) b.get(bLastIndex) * m) % MOD);
        b.set(bLastIndex, bLast);
    }

    public int getIndex(int idx) {
        if (idx >= v.size()) {
            return -1;
        }
        int ao = (int) (((long) inv(a.get(idx)) * a.get(a.size() - 1)) % MOD);
        int bo = (int) (((long) b.get(b.size() - 1) -
                ((long) b.get(idx) * ao) % MOD +
                MOD) %
                MOD);
        int ans = (int) (((((long) ao * v.get(idx)) % MOD) + bo) % MOD);
        return ans;
    }

    // fast exponentiation
    private int quickmul(int x, int y) {
        long ret = 1;
        long cur = x;
        while (y != 0) {
            if ((y & 1) != 0) {
                ret = (ret * cur) % MOD;
            }
            cur = (cur * cur) % MOD;
            y >>= 1;
        }
        return (int) ret;
    }

    // multiplicative inverse
    private int inv(int x) {
        return quickmul(x, MOD - 2);
    }
}
