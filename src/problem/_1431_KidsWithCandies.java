package problem;

import java.util.ArrayList;
import java.util.List;

public class _1431_KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ret = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i: candies) {
            max = Math.max(max, i);
        }
        for (int i: candies) {
            ret.add(i + extraCandies >= max);
        }
        return ret;
    }
}
