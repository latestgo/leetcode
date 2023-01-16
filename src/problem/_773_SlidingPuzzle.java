package problem;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class _773_SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        String targetStr = "123450";
        StringBuilder currentStr = new StringBuilder();
        int[][] movement = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                currentStr.append(board[i][j]);
            }
        }
        if (currentStr.toString().equals(targetStr)) {
            return 0;
        }

        int step = 0;
        Queue<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        queue.add(currentStr.toString());
        seen.add(currentStr.toString());
        while (!queue.isEmpty()) {
            step++;
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                StringBuilder str = new StringBuilder(queue.remove());
                int index = str.indexOf("0");
                int[] move = movement[index];
                for (int k : move) {
                    str.setCharAt(index, str.charAt(k));
                    str.setCharAt(k, '0');
                    String nextStr = str.toString();
                    str.setCharAt(k, str.charAt(index));
                    str.setCharAt(index, '0');
                    if (seen.contains(nextStr)) {
                        continue;
                    }
                    if (nextStr.equals(targetStr)) {
                        return step;
                    }
                    queue.add(nextStr);
                    seen.add(nextStr);
                }
            }
        }
        return -1;
    }
}
