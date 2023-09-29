package com.bit.manipulation;

import java.util.BitSet;

public class OperationOnBitSet {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(3);
        bitSet.set(0);
        bitSet.set(2);
        System.out.println("length : " +bitSet.length());
        System.out.println("size : " +bitSet.size());
        System.out.println("toString : " +bitSet.toString());
        System.out.println("cardinality : " +bitSet.cardinality());


    }
}
