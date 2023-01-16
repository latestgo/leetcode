package problem;

import java.util.*;

public class _1606_BusiestServers {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 使用优先队列存储正忙的机器
        Queue<int[]> busyQ = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // 计数
        int[] count = new int[k];
        int max = Integer.MIN_VALUE;

        // 记录空闲机器
        TreeSet<Integer> available = new TreeSet<>();

        // 初始化
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            while (!busyQ.isEmpty() && busyQ.peek()[1] <= arrival[i]) {
                available.add(busyQ.remove()[0]);
            }
            if (!available.isEmpty()) {
                Integer position = available.ceiling(i % k);
                if (position == null) {
                    position = available.first();
                }
                available.remove(position);
                busyQ.add(new int[]{position, arrival[i] + load[i]});
                max = Math.max(++count[position], max);
            }
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ret.add(i);
            }
        }
        return ret;
    }

    public List<Integer> busiestServers1(int k, int[] arrival, int[] load) {
        // 模拟，未优化
        int[] count = new int[k];
        int[] time = new int[k];
        count[0]++;
        time[0] = load[0];
        for (int i = 1; i < arrival.length; i++) {
            // clear last time
            int timeDis = arrival[i] - arrival[i - 1];
            for (int j = 0; j < k; j++) {
                time[j] = time[j] > timeDis ? time[j] - timeDis : 0;
            }

            int position = i % k;
            for (int j = 0; j < k; j++) {
                int realP = (j + position) % k;
                if (time[realP] == 0) {
                    time[realP] = load[i];
                    count[realP]++;
                    break;
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (count[i] > max) {
                ret.clear();
                ret.add(i);
                max = count[i];
            } else if (count[i] == max) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new _1606_BusiestServers().busiestServers(2, new int[]{1, 2, 3,}, new int[]{1000000000,1,1000000000});
    }
}
