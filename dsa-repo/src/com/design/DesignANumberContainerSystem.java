package com.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/*
2349. Design a Number Container System

Design a number container system that can do the following:

Insert or Replace a number at the given index in the system.
Return the smallest index for the given number in the system.
Implement the NumberContainers class:

NumberContainers() Initializes the number container system.
void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.


Example 1:

Input
["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
Output
[null, -1, null, null, null, null, 1, null, 2]

TC : o(n)
SC o(n)
 */
public class DesignANumberContainerSystem {

    public static void main(String[] args) {
        NumberContainers obj = new NumberContainers();
        System.out.println(obj.find(10));
        obj.change(2,10);
        obj.change(1,10);
        obj.change(3,10);
        obj.change(5,10);
        System.out.println(obj.find(10));
        obj.change(1,20);
        System.out.println(obj.find(10));
    }
}

class NumberContainers {

    Map<Integer, Integer> indexMap;
    Map<Integer, TreeSet<Integer>> numMap;
    public NumberContainers() {
        numMap = new HashMap<>();
        indexMap = new HashMap<>();
    }

    public void change(int index, int number) {

        if(indexMap.containsKey(index)){
            int num = indexMap.get(index);
            numMap.get(num).remove(index);
            if(numMap.get(num).isEmpty()){
                numMap.remove(num);
            }
        }
        indexMap.put(index, number);
        numMap.putIfAbsent(number, new TreeSet<>());
        numMap.get(number).add(index);
    }

    public int find(int number) {
        if(numMap.containsKey(number)){
            return numMap.get(number).first();
        }
        return -1;
    }
}
