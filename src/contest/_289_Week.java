package contest;

import java.util.HashMap;
import java.util.Map;

public class _289_Week {
    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            count++;
            if (count == k || i == s.length() - 1) {
                sb.append(sum);
                count = 0;
                sum = 0;
            }
        }
        return digitSum(sb.toString(), k);
    }

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int n : tasks) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int k : map.keySet()) {
            int v = map.get(k);
            if (v == 1) {
                return -1;
            }
            ret += v / 3;
            if (v % 3 > 0) {
                ret += 1;
            }
        }
        return ret;
    }

    public int maxTrailingZeros(int[][] grid) {
        int yLen = grid.length;
        int xLen = grid[0].length;
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < xLen; i++) {
            int times = 1;
            for (int j = 0; j < yLen; j++) {
                times *= grid[j][i];

                int leftTimes = times;
                for (int k = i - 1; k > -1; k--) {
                    leftTimes *= grid[j][k];
                }
                ret = Math.max(ret, countZero(leftTimes));
                int rightTimes = times;
                for (int k = i + 1; k < xLen; k++) {
                    rightTimes *= grid[j][k];
                }
                ret = Math.max(ret, countZero(rightTimes));
            }
        }
        for (int i = 0; i < yLen; i++) {
            int times = 1;
            for (int j = 0; j < xLen; j++) {
                times *= grid[i][j];

                int leftTimes = times;
                for (int k = i - 1; k > -1; k--) {
                    leftTimes *= grid[k][j];
                }
                ret = Math.max(ret, countZero(leftTimes));
                int rightTimes = times;
                for (int k = i + 1; k < yLen; k++) {
                    rightTimes *= grid[k][j];
                }
                ret = Math.max(ret, countZero(rightTimes));
            }
        }
        return ret;
    }

    private int countZero(int n) {
        int c = 0;
        while (n % 10 == 0) {
            c++;
            n = n / 10;
        }
        return c;
    }
}
