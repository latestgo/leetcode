package problem;

import java.util.Arrays;

public class _462_MinMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        if (nums.length / 2 == 0) {
            mid = (mid + nums[nums.length - 1]) / 2;
        }
        int ret = 0;
        for (int n : nums) {
            ret += Math.abs(n - mid);
        }
        return ret;
    }
}
