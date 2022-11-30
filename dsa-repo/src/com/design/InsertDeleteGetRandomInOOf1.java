package com.design;

import java.util.*;

/*
380. Insert Delete GetRandom O(1)

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
    false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements
    (it's guaranteed that at least one element exists when this method is called).
    Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.



Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

Intuition
As the name of the class says, it shall behave like a set upon insertion or removal of values.
So a "set-ish" abstract data type is needed to store the values, and will allow constant access times for
insertion and removal.
The randomized get() requires to use a random number generator to calculate the choice, and one can assume,
that the library standard provides such a constant time random number generator.
But the Java sets do not provide constant time random access methods to the stored items by index. Thus,
a common set must probably be iterated.
To support both acess methods (insert/remove by key, and get by randomized index), a kind of hybrid data
structure is needed: a set that can be accessed randomly by index, like a list, and by key, like a set or map.


Approach
Use a HashMap to store the inserted values (as keys), so that the set aspect gets satisfied.
Use an ArrayList to store the values as themselves, and use the indexes of the values in the list as values
for the key map. This satisfies the random access by index requirement.
Both tables are associated by the indexes:
HashMap: value (key aspect) --> index
ArrayList: index --> value (value aspect).

Complexity
Time complexity: $$O(1)$$ average for all operations
Space complexity: $$O(n)$$, where n is the number of items stored in the class at any time.
    Grows by one with each successful insertion, shrinks by one with each successful removal.
 */
public class InsertDeleteGetRandomInOOf1 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}

class RandomizedSet {

    private Map<Integer,Integer> keys;
    private List<Integer> values;
    public RandomizedSet() {
        keys = new HashMap<>();
        values = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(keys.containsKey(val)){
            return false;
        }
        keys.put(val, values.size());
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!keys.containsKey(val)){
            return false;
        }
        int candidateIndex = keys.get(val);
        int lastIndex = values.size()-1;
        values.set(candidateIndex, values.get(lastIndex));
        keys.put(values.get(candidateIndex),candidateIndex);
        keys.remove(val);
        values.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int randomVal = new Random().nextInt(values.size());
        return values.get(randomVal);
    }
}