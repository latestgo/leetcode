package problem;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class _442_FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = Math.abs(nums[i]);
            if (nums[t - 1] < 0) {
                ret.add(t);
            } else {
                nums[t - 1] = -nums[t - 1];
            }
        }
        return ret;
    }
}
