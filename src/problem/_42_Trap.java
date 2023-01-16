package problem;

import java.util.*;
import java.util.stream.Collectors;

public class _42_Trap {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i --) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            ret += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ret;
    }

    public int trap1(int[] height) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            int finalI = i;
            map.compute(height[i], (k, oldV) -> {
                if (oldV == null) {
                    oldV = new ArrayList<>();
                }
                oldV.add(finalI);
                return oldV;
            });
            max = Math.max(max, height[i]);
        }
        int ret = 0;
        for (int i = 0; i < max; i++) {
            int r = -1;
            for (int j = 0; j < height.length; j++) {
                if (j < r) {
                    continue;
                }
                int[] pos = get(height, j, i);
                if (pos != null) {
                    r = pos[1];
                    ret += pos[1] - pos[0] - 1;
                }
            }
        }
        return ret;
    }

    private int[] get(int[] height, int i, int h) {
        if (height[i] > h) {
            return null;
        }
        int l = i, r = i;
        while (height[l] <= h) {
            l--;
            if (l < 0) {
                return null;
            }
        }

        while (height[r] <= h) {
            r++;
            if (r > height.length - 1) {
                return null;
            }
        }

        return new int[]{l, r};
    }
}
