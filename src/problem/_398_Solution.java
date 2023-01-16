package problem;

import java.util.*;

public class _398_Solution {
}

class Solution1 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Random r = new Random(0);
    int[] nums;
    public Solution1(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(r.nextInt(list.size()));
    }
}
