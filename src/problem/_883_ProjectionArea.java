package problem;

public class _883_ProjectionArea {
    public int projectionArea(int[][] grid) {
        int ret = 0;
        for (int[] ints : grid) {
            int max = Integer.MIN_VALUE;
            for (int anInt : ints) {
                max = Math.max(max, anInt);
                if (anInt > 0) {
                    ret += 1;
                }
            }
            ret += max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            ret += max;
        }

        return ret;
    }
}
