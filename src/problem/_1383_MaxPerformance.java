package problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1383_MaxPerformance {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = speed[i];
            data[i][1] = efficiency[i];
        }

        Arrays.sort(data, Comparator.comparingInt((int[] a) -> -a[1]));
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (int[] datum : data) {
            if (queue.size() == k) {
                sum -= queue.remove()[0];
            }
            sum += datum[0];
            max = Math.max(max, sum * datum[1]);
            queue.add(datum);
        }
        return (int) (max % (long)(1e9 + 7));
    }

    long max = Long.MIN_VALUE;
    public int maxPerformance1(int n, int[] speed, int[] efficiency, int k) {
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = 1;
            recur(n, speed, efficiency, visited, k, 1, speed[i], efficiency[i]);
        }
        return (int) (max % (10e9 + 7));
    }

    private void recur(int n, int[] speed, int[] efficiency, int[] visited, int k, int d, int speedSum, int minEfficiency) {
        if (k >= d) {
            long tmp = (long) speedSum * (long) minEfficiency;
            max = Math.max(max, tmp);
        } else {
            return;
        }
        for (int j = 0; j < n; j++) {
            if (visited[j] == 0) {
                visited[j] = 1;
                recur(n, speed, efficiency, visited, k, d + 1, speedSum + speed[j], Math.min(efficiency[j], minEfficiency));
                visited[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        _1383_MaxPerformance p = new _1383_MaxPerformance();
//        p.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2);
        int i = p.maxPerformance(3, new int[]{2, 8, 2}, new int[]{2, 7, 1}, 2);
        System.out.println(i);
    }
}
