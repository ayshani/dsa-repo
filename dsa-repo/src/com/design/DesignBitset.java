package com.design;

import java.util.Arrays;

/*
2166. Design Bitset

A Bitset is a data structure that compactly stores bits.

Implement the Bitset class:

Bitset(int size) Initializes the Bitset with size bits, all of which are 0.
void fix(int idx) Updates the value of the bit at the index idx to 1. If the value was already 1, no change occurs.
void unfix(int idx) Updates the value of the bit at the index idx to 0. If the value was already 0, no change occurs.
void flip() Flips the values of each bit in the Bitset. In other words, all bits with value 0 will now have value
    1 and vice versa.
boolean all() Checks if the value of each bit in the Bitset is 1. Returns true if it satisfies the condition,
    false otherwise.
boolean one() Checks if there is at least one bit in the Bitset with value 1. Returns true if it satisfies the
    condition, false otherwise.
int count() Returns the total number of bits in the Bitset which have value 1.
String toString() Returns the current composition of the Bitset. Note that in the resultant string, the character
    at the ith index should coincide with the value at the ith bit of the Bitset.


Example 1:

Input
["Bitset", "fix", "fix", "flip", "all", "unfix", "flip", "one", "unfix", "count", "toString"]
[[5], [3], [1], [], [], [0], [], [], [0], [], []]
Output
[null, null, null, null, false, null, null, true, null, 2, "01010"]

Explanation
Bitset bs = new Bitset(5); // bitset = "00000".
bs.fix(3);     // the value at idx = 3 is updated to 1, so bitset = "00010".
bs.fix(1);     // the value at idx = 1 is updated to 1, so bitset = "01010".
bs.flip();     // the value of each bit is flipped, so bitset = "10101".
bs.all();      // return False, as not all values of the bitset are 1.
bs.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "00101".
bs.flip();     // the value of each bit is flipped, so bitset = "11010".
bs.one();      // return True, as there is at least 1 index with value 1.
bs.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "01010".
bs.count();    // return 2, as there are 2 bits with value 1.
bs.toString(); // return "01010", which is the composition of bitset.

Intuition
The intention is to provide O(1) on every operation. What if we maintain both straignt and flipped flags
at the same time?
To reduce the time on building String what if we store the bits as a char array?

Approach
So we maintain 2 arrays bits and flippedBits as char[] of '0' or '1'
On the flip operation we just swap the arrays.

Complexity
Time complexity:
O(1) on all operation except toString() - we don't iterate there explicitly but internally toString() does.

Space complexity:
O(N)
 */
public class DesignBitset {
    public static void main(String[] args) {
        Bitset bs = new Bitset(5); // bitset = "00000".
        bs.fix(3);     // the value at idx = 3 is updated to 1, so bitset = "00010".
        bs.fix(1);     // the value at idx = 1 is updated to 1, so bitset = "01010".
        bs.flip();     // the value of each bit is flipped, so bitset = "10101".
        System.out.println(bs.all());
        bs.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "00101".
        bs.flip();     // the value of each bit is flipped, so bitset = "11010".
        System.out.println(bs.one());
        bs.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "01010".
        System.out.println(bs.count());
        System.out.println(bs.toString());
    }
}

class Bitset {

    char[] bits, flippedBits;
    int oneCount;

    public Bitset(int size) {
        bits = new char[size];
        Arrays.fill(bits, '0');
        flippedBits = new char[size];
        Arrays.fill(flippedBits, '1');
        oneCount =0;
    }

    public void fix(int idx) {
        oneCount += bits[idx] == '0' ? 1 :0;
        bits[idx] = '1';
        flippedBits[idx] ='0';
    }

    public void unfix(int idx) {
        oneCount -= bits[idx] == '1' ? 1 :0;
        bits[idx] = '0';
        flippedBits[idx] ='1';
    }

    public void flip() {
        char[] aux = bits;
        bits = flippedBits;
        flippedBits = aux;
        oneCount = bits.length - oneCount;
    }

    public boolean all() {
        return oneCount == bits.length;
    }

    public boolean one() {
        return oneCount>0;
    }

    public int count() {
        return oneCount;
    }

    public String toString() {
        return new String(bits);
    }
}
