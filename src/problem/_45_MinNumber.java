package problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class _45_MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
           strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        return String.join("", strs);
    }
}
