package offer;

public class Offer_47_MaxValue {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
    private int maxValue = Integer.MIN_VALUE;
    public int maxValue1(int[][] grid) {
        dfs(grid, 0, 0, 0);
        return maxValue;
    }

    private void dfs(int[][] grid, int i, int j, int value) {
        maxValue = Math.max(value, maxValue);
        if (i < grid.length && j < grid[0].length) {
            dfs(grid, i + 1, j, value + grid[i][j]);
            dfs(grid, i, j + 1, value + grid[i][j]);
        }
    }
}
