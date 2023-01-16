package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _679_FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            map.compute(nums[i], (k, oldV) -> {
                List<Integer> list = oldV;
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(1);
                    list.add(finalI);
                    list.add(finalI);
                } else {
                    list.set(0, oldV.get(0) + 1);
                    list.set(2, finalI);
                }
                return list;
            });
        }

        int t = Integer.MIN_VALUE, c = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> a : map.entrySet()) {
            int tt = a.getValue().get(0);
            int tc = a.getValue().get(2) - a.getValue().get(1) + 1;
            if (tt > t || tt == t && tc < c) {
                t = tt;
                c = tc;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        new _679_FindShortestSubArray().findShortestSubArray(new int[] {1,2,2,3,1});
    }
}
