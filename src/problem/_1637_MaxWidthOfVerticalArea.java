package problem;

import java.util.Arrays;
import java.util.Comparator;

public class _1637_MaxWidthOfVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] - points[i-1][0] > max) {
                max = points[i][0] - points[i-1][0];
            }
        }
        return max;
    }
}
