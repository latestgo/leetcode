package problem;

import java.util.*;

public class _380_RandomizedSet {
}
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    Random random = new Random(1);
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int ix = map.get(val);
        int endE = list.get(list.size() - 1);
        list.set(ix, endE);
        list.remove(list.size() - 1);
        map.put(endE, ix);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
