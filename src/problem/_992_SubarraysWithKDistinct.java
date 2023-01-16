package problem;

import java.util.HashMap;
import java.util.Map;

public class _992_SubarraysWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l1 = 0, l2 = 0, r = 0;
        int len = nums.length;
        map.put(nums[0], 1);
        while (r < len) {

        }
        return 0;
    }

    public static void main(String[] args) {
        new _992_SubarraysWithKDistinct().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);
    }

}
