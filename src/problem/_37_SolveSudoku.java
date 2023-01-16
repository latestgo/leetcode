package problem;

import java.util.*;

public class _37_SolveSudoku {

    boolean[][] rowVis = new boolean[9][9];
    boolean[][] colVis = new boolean[9][9];
    boolean[][][] blockVis = new boolean[3][3][9];
    List<int[]> positions = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rowVis[i][c - '1'] = colVis[j][c - '1'] = blockVis[i / 3][j / 3][c - '1'] = true;
                } else {
                    positions.add(new int[]{i, j});
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int k) {
        if (k == positions.size()) {
            valid = true;
            return;
        }
        int[] pos = positions.get(k);
        int x = pos[0], y = pos[1];
        for (char j = '1'; j <= '9' && !valid; j++) {
            int v = j - '1';
            if (!rowVis[x][v] && !colVis[y][v] && !blockVis[x / 3][y / 3][v]) {
                board[x][y] = j;
                rowVis[x][v] = colVis[y][v] = blockVis[x / 3][y / 3][v] = true;
                dfs(board, k + 1);
                //                board[x][y] = '.';
                rowVis[x][v] = colVis[y][v] = blockVis[x / 3][y / 3][v] = false;
            }
        }

    }

    public static void main(String[] args) {
        var data = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new _37_SolveSudoku().solveSudoku(data);
        for (char[] datum : data) {
            for (char c : datum) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }
}
