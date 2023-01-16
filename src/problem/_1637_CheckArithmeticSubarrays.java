package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1637_CheckArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ret = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            Set<Integer> set = new HashSet<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count = r[i] - l[i] + 1;
            for (int j = l[i]; j <= r[i]; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }
            if (max - min == 0) {
                ret.add(true);
            } else if ((max - min) % (count - 1) != 0) {
                ret.add(false);
            } else {
                int dis = (max - min) / (count - 1);
                for (int j = l[i]; j <= r[i]; j++) {
                    int n = (nums[j] - min) / dis;
                    int re = (nums[j] - min) % dis;
                    if (set.contains(n) || re != 0) {
                        break;
                    } else {
                        set.add(n);
                    }
                }
                if (set.size() != count) {
                    ret.add(false);
                } else {
                    ret.add(true);
                }
            }

        }
        return ret;
    }
}
