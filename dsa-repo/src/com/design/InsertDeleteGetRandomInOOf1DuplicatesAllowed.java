package com.design;

import java.util.*;

/*
381. Insert Delete GetRandom O(1) - Duplicates allowed

RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also removing a random element.

Implement the RandomizedCollection class:

RandomizedCollection() Initializes the empty RandomizedCollection object.
bool insert(int val) Inserts an item val into the multiset, even if the item is already present.
    Returns true if the item is not present, false otherwise.
bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present,
    false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
int getRandom() Returns a random element from the current multiset of elements. The probability of each
    element being returned is linearly related to the number of same values the multiset contains.
You must implement the functions of the class such that each function works on average O(1) time complexity.

Note: The test cases are generated such that getRandom will only be called if there is at least one item in
the RandomizedCollection.



Example 1:

Input
["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
[[], [1], [1], [2], [], [1], []]
Output
[null, true, false, true, 2, true, 1]

Explanation
RandomizedCollection randomizedCollection = new RandomizedCollection();
randomizedCollection.insert(1);   // return true since the collection does not contain 1.
                                  // Inserts 1 into the collection.
randomizedCollection.insert(1);   // return false since the collection contains 1.
                                  // Inserts another 1 into the collection. Collection now contains [1,1].
randomizedCollection.insert(2);   // return true since the collection does not contain 2.
                                  // Inserts 2 into the collection. Collection now contains [1,1,2].
randomizedCollection.getRandom(); // getRandom should:
                                  // - return 1 with probability 2/3, or
                                  // - return 2 with probability 1/3.
randomizedCollection.remove(1);   // return true since the collection contains 1.
                                  // Removes 1 from the collection. Collection now contains [1,2].
randomizedCollection.getRandom(); // getRandom should return 1 or 2, both equally likely.

Algorithm

We will keep a list to store all our elements. In order to make finding the index of elements we want to
remove O(1), we will use a HashMap or dictionary to map values to all indices that have those values.
To make this work each value will be mapped to a set of indices.
The tricky part is properly updating the HashMap as we modify the list.

insert: Append the element to the list and add the index to HashMap[element].
remove: This is the tricky part. We find the index of the element using the HashMap.
    We use the trick discussed in the intuition to remove the element from the list in O(1).
    Since the last element in the list gets moved around, we have to update its value in the HashMap.
    We also have to get rid of the index of the element we removed from the HashMap.
getRandom: Sample a random element from the list.

Complexity Analysis

Time complexity : O(N), with NN being the number of operations.
All of our operations are O(1), giving N * O(1) = O(N).

Space complexity : O(N), with NN being the number of operations.
The worst case scenario is if we get N add operations, in which case our ArrayList and our HashMap grow to size N.


 */
public class InsertDeleteGetRandomInOOf1DuplicatesAllowed {
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(1));
        System.out.println(randomizedCollection.insert(2));
        System.out.println(randomizedCollection.getRandom());
        System.out.println(randomizedCollection.remove(1));
        System.out.println(randomizedCollection.getRandom());

    }
}

class RandomizedCollection {
    private List<Integer> values;
    private Map<Integer, Set<Integer>> keys;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        values = new ArrayList<>();
        keys = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the
     collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!keys.containsKey(val)){
            keys.put(val,new LinkedHashSet<Integer>());
        }
        keys.get(val).add(values.size());
        values.add(val);
        return keys.get(val).size()==1;
    }

    /** Removes a value from the collection.
     Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!keys.containsKey(val) || keys.get(val).size()==0)
            return false;

        int removeIndex = keys.get(val).iterator().next();
        keys.get(val).remove(removeIndex);
        int lastElementOfValues = values.get(values.size()-1);
        values.set(removeIndex, lastElementOfValues);
        keys.get(lastElementOfValues).add(removeIndex);
        keys.get(lastElementOfValues).remove(values.size()-1);

        values.remove(values.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int randomChoice = new Random().nextInt(values.size());
        return values.get(randomChoice);
    }
}
