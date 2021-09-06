package leetcode_topInterview;

import java.util.*;

public class InsertDeleteGetRandom_380 {

    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            } else {
                list.add(val);
                map.put(val, list.size() - 1);
            }
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            // 删除时，如果删除list中的一个元素，会导致其他位置的index改变，所以需要将要删除的那个索引和最后位置的元素交换，然后删除最后一个元素
            // 并更改之前那个元素的index
            if (!map.containsKey(val)) {
                return false;
            } else {
                if (list.size() == 1) {
                    list.remove(list.size() - 1);
                    map.remove(val);
                    return true;
                }
                int index = map.get(val);
                int lastVal = list.get(list.size() - 1);
                map.put(lastVal, index);
                list.set(index, lastVal);
                list.remove(list.size() - 1);
                map.remove(val);
            }
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }

}
