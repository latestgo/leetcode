package problem;

import java.util.ArrayList;
import java.util.List;

public class _933_Solution {

    static class RecentCounter {

        List<Integer> list;
        public RecentCounter() {
            list = new ArrayList<>();
        }

        public int ping(int t) {
            int i = binarySearch(t - 3000);
            list.add(t);
            if (i > -1) {
                return list.size() - i;
            } else {
                return list.size() + i + 1;
            }
        }

        private int binarySearch(int t) {
            int l = 0, r = list.size() - 1;
            while (l <= r) {
                int mid = (r + l) >>> 1;
                int midValue = list.get(mid);
                if (midValue == t) {
                    return mid;
                } else if (midValue > t) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return -(l + 1);
        }
    }

    public static void main(String[] args) {
        RecentCounter cou = new RecentCounter();
        cou.ping(1);
        cou.ping(100);
        cou.ping(3001);
        cou.ping(3002);
        cou.ping(6000);
        cou.ping(7000);
        cou.ping(8000);
        cou.ping(100000);
    }
}
