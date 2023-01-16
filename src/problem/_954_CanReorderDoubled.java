package problem;

import java.util.*;

public class _954_CanReorderDoubled {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(Math::abs));
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int zeroC = map.getOrDefault(0, 0);
        if (zeroC % 2 != 0) {
            return false;
        }
        List<Integer> vals = new ArrayList<>(map.keySet());
        for (int i : vals) {
            int c = map.get(i);
            if (map.getOrDefault(2 * i, 0) < c) {
                return false;
            }
            map.put(2 * i, map.getOrDefault(2 * i, 0) - c);
        }
        return true;
    }

    public static void main(String[] args) {
        new _954_CanReorderDoubled().canReorderDoubled(new int[]{ 4, 2});
    }
}
