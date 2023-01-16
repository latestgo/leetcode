package problem;

public class _807_MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int xMax = Integer.MIN_VALUE;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] > xMax) {
                        xMax = grid[i][k];
                    }
                }
                int yMax = Integer.MIN_VALUE;
                for (int k = 0; k < grid.length; k++) {
                    if (grid[k][j] > yMax) {
                        yMax = grid[k][j];
                    }
                }
                sum += Math.min(xMax, yMax) - grid[i][j] ;
            }
        }
        return sum;
    }
}
