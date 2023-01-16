package problem;

import java.util.Arrays;

public class _1828_CountPoints {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ret = new int[queries.length];
        Arrays.fill(ret, 0);
        for (int i = 0; i < queries.length; i++) {
            int s = 0;
            int rr = queries[i][2] * queries[i][2];
            for (int j = 0; j < points.length; j++) {
                int x = points[j][0] - queries[i][0];
                int y = points[j][1] - queries[i][1];
                if (x * x + y * y <= rr) {
                    ret[i] += 1;
                }
            }
        }
        return ret;
    }
}
