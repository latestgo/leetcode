package problem;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class _52_TotalNQueens {
    int ret = 0;
    public int totalNQueens(int n) {
        int[][] visited = new int[n][n];
        for (int[] v: visited) {
            Arrays.fill(v, 0);
        }
        for (int i = 0; i < n; i++) {
            visited[0][i] = 1;
            visited(n, 0, i, visited, v -> v + 1);
            dfs(n, 1, visited);
            visited[0][i] = 0;
            visited(n, 0, i, visited, v -> v - 1);
        }
        return ret;
    }

    private void dfs(int n, int k, int[][] visited) {
        if (k == n) {
            ret++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[k][i] == 0) {
                visited[k][i] = 1;
                visited(n, k, i, visited, v -> v + 1);
                dfs(n, k + 1, visited);
                visited[k][i] = 0;
                visited(n, k, i, visited, v -> v - 1);
            }
        }
    }

    private void visited(int n, int x, int y, int[][] visited, Function<Integer, Integer> fc) {
        int xx = x, yy = y;
        while (--xx >= 0 && --yy >= 0) {
            visited[xx][yy] = fc.apply(visited[xx][yy]);
        }
        xx = x; yy = y;
        while (++xx < n && ++yy < n) {
            visited[xx][yy] = fc.apply(visited[xx][yy]);
        }
        xx = x; yy = y;
        while (--xx >= 0 && ++yy < n) {
            visited[xx][yy] = fc.apply(visited[xx][yy]);
        }
        xx = x; yy = y;
        while (++xx < n && --yy >= 0) {
            visited[xx][yy] = fc.apply(visited[xx][yy]);
        }
        for (int i = 0; i < n; i++) {
            if (i != x) {
                visited[i][y] = fc.apply(visited[i][y]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != y) {
                visited[x][i] = fc.apply(visited[x][i]);
            }
        }
    }
}
