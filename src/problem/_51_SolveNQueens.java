package problem;

import java.util.*;
import java.util.stream.Collectors;

public class _51_SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        String[][] visited = new String[n][n];
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited[0][i] = "Q";
            putValue(n, visited, 0, i, true);
            dfs(n, 1, visited, ret);
            putValue(n, visited, 0, i, false);
            visited[0][i] = "";
        }
        return ret;
    }


    private void dfs(int n, int k, String[][] visited, List<List<String>> ret) {
        if (k == n) {
            ret.add(Arrays.stream(visited).map( v -> Arrays.stream(v).map( i -> i.replaceFirst("\\.+", ".")).collect(Collectors.joining())).collect(Collectors.toList()));
            return ;
        }
        for (int i = 0; i < n; i++) {
            if (visited[k][i] == null || visited[k][i].isBlank()) {
                visited[k][i] = "Q";
                putValue(n, visited, k, i, true);
                dfs(n, k + 1, visited, ret);
                visited[k][i] = "";
                putValue(n, visited, k, i, false);
            }
        }
    }

    private void putValue(int n, String[][] arr,int x, int y, boolean put) {
        int xx = x, yy = y;
        while (--xx >= 0 && --yy >= 0) {
            if (put) {
                arr[xx][yy] = arr[xx][yy] == null ? "." : arr[xx][yy] + ".";
            } else {
                arr[xx][yy] = arr[xx][yy].replaceFirst("\\.", "");
            }
        }
        xx = x; yy = y;
        while (++xx < n && ++yy < n) {
            if (put) {
                arr[xx][yy] = arr[xx][yy] == null ? "." : arr[xx][yy] + ".";
            } else {
                arr[xx][yy] = arr[xx][yy].replaceFirst("\\.", "");
            }
        }
        xx = x; yy = y;
        while (++xx < n && --yy >= 0) {
            if (put) {
                arr[xx][yy] = arr[xx][yy] == null ? "." : arr[xx][yy] + ".";
            } else {
                arr[xx][yy] = arr[xx][yy].replaceFirst("\\.", "");
            }
        }
        xx = x; yy = y;
        while (--xx > 0 && ++yy < n) {
            if (put) {
                arr[xx][yy] = arr[xx][yy] == null ? "." : arr[xx][yy] + ".";
            } else {
                arr[xx][yy] = arr[xx][yy].replaceFirst("\\.", "");
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == x)  continue;
            if (put) {
                arr[i][y] = arr[i][y] == null ? "." : arr[i][y] + ".";
            } else {
                arr[i][y] = arr[i][y].replaceFirst("\\.", "");
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == y)  continue;
            if (put) {
                arr[x][i] = arr[x][i] == null ? "." : arr[x][i] + ".";
            } else {
                arr[x][i] = arr[x][i].replaceFirst("\\.", "");
            }
        }
    }

    public static void main(String[] args) {
        new _51_SolveNQueens().solveNQueens(1);
    }
}
