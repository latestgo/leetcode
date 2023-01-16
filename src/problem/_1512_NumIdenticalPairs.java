package problem;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _1512_NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int n: nums) {
            int cur = map.getOrDefault(n, -1) + 1;
            map.put(n, cur);
            ret += cur;
        }
        return ret;
    }

    public static void main(String[] args) {
        new _1512_NumIdenticalPairs().numIdenticalPairs(new int[]{1, 2});
    }
}
