package problem;

import java.util.Arrays;

public class _1402_MaxSatisfaction {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ret = 0;
        int sum = 0;
        int len = satisfaction.length;
        int i = len - 1;
        while (i >= 0) {
            if (satisfaction[i] + sum > 0) {
                sum += satisfaction[i];
            } else {
                break;
            }
            i--;
        }
        int j = 1;
        while (++i <= len -1) {
            ret += satisfaction[i] * j;
            j ++;
        }
        return ret;
    }

    int max = Integer.MIN_VALUE;

    public int maxSatisfaction1(int[] satisfaction) {
        int[] visited = new int[satisfaction.length];
        for (int i = 0; i < satisfaction.length; i++) {
            visited[i] = 1;
            recur(satisfaction, visited, satisfaction[i], 1, 1);
            recur(satisfaction, visited, 0, 0, 1);
            visited[0] = 0;
        }
        return max;
    }

    private void recur(int[] satisfaction, int[] visited, int sum, int k, int depth) {
        if (depth == satisfaction.length) {
            max = Math.max(max, sum);
        }
        for (int i = 0; i < satisfaction.length; i++) {
            if (visited[i] < 1) {
                visited[i] = 1;
                recur(satisfaction, visited, sum + k * satisfaction[i], k + 1, depth + 1);
                recur(satisfaction, visited, sum, k, depth + 1);
                visited[i] = 0;
            }
        }
    }
}
