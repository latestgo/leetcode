package contest;

import java.util.*;

public class _290_Week {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        Arrays.fill(count, 0);
        for (int[] num : nums) {
            for (int n : num) {
                count[n]++;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == nums.length) {
                ret.add(i);
            }
        }
        return ret;
    }

    public int countLatticePoints(int[][] circles) {
        int ret = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int[] circle : circles) {
                    int disX = Math.abs(i - circle[0]);
                    int disY = Math.abs(j - circle[1]);
                    if (disX * disX + disY * disY <= circle[2] * circle[2]) {
                        ret++;
                        break;
                    }
                }
            }
        }
        return ret;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int[] ret = new int[points.length];
        Arrays.fill(ret, 0);
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        int[] count = new int[rectangles.length];
        count[rectangles.length - 1] = 0;
        for (int i = 0; i < rectangles.length - 2; i++) {
        }
        return ret;
    }

    public static void main(String[] args) {
        new _290_Week().countRectangles(new int[][]{{7, 1}, {2, 6}, {1, 4}, {5, 2}, {10, 3}, {2, 4}, {5, 9}}, new int[][]{{2, 4}, {3, 6}});
    }
}
