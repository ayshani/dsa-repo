package com.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
341. Flatten Nested List Iterator

You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements
may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
Your code will be tested with the following pseudocode:

initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
If res matches the expected flattened list, then your code will be judged as correct.

Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next
should be: [1,1,2,1,1].

 */
public class FlattenNestedListIterator {

    public static void main(String[] args) {

    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return empty list if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    List<Integer> intList = new ArrayList<>();
    int index=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger ni : nestedList){
            flatten(ni);
        }
    }

    private void flatten(NestedInteger ni){
        if(ni.isInteger()){
            intList.add(ni.getInteger());
        } else {
            for(NestedInteger n : ni.getList()){
                flatten(n);
            }
        }
    }

    @Override
    public Integer next() {
        return intList.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<intList.size();
    }
}
