package problem;

import java.util.ArrayList;
import java.util.List;

public class _417_PacificAtlantic {
    List<List<Integer>> ret = new ArrayList<>();
    int[][] count;
    int[][] count2;
    boolean[][] visited;
    int x = -1, y = -1;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        count = new int[heights.length][heights[0].length];
        count2 = new int[heights.length][heights[0].length];
        visited = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                x = i;
                y = j;
                dfs(heights, i, j);
            }
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[0].length; j++) {
                if (count[i][j] + count2[i][j] == 2) {
                    ret.add(List.of(i, j));
                }
            }
        }
        return ret;
    }

    private void dfs(int[][] heights, int i, int j) {
        if (count[i][j] + count2[i][j]== 2) {
            count[x][y] = 1;
            count2[x][y] = 1;
            return;
        }
        if (i == 0 || j == 0) {
            count[x][y] = 1;
        }
        if (i == heights.length - 1 || j == heights[0].length - 1) {
            count2[x][y] = 1;
        }
        if (count[x][y] + count2[x][y] == 2) {
            return;
        }
        if (i > 0 && heights[i][j] >= heights[i - 1][j] && !visited[i - 1][j]) {
            visited[i][j] = true;
            dfs(heights, i - 1, j);
            visited[i][j] = false;
        }
        if (i < heights.length - 1 && heights[i][j] >= heights[i + 1][j] && !visited[i + 1][j]) {
            visited[i][j] = true;
            dfs(heights, i + 1, j);
            visited[i][j] = false;
        }

        if (j > 0 && heights[i][j] >= heights[i][j - 1] && !visited[i][j - 1]) {
            visited[i][j] = true;
            dfs(heights, i, j - 1);
            visited[i][j] = false;
        }

        if (j < heights[0].length - 1 && heights[i][j] >= heights[i][j + 1] && !visited[i][j + 1]) {
            visited[i][j] = true;
            dfs(heights, i, j + 1);
            visited[i][j] = false;
        }
    }

    public static void main(String[] args) {
        new _417_PacificAtlantic().pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
    }
}
