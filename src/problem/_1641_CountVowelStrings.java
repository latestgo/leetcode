package problem;

import java.util.Arrays;
import java.util.Comparator;


public class _1641_CountVowelStrings {
    public int countVowelStrings(int n) {
        int ret = 0;
        for (int i = 5; i > 0; i--) {
            int start = i;
            for (int j = 0; j < n; j++) {
                if (start == 1) {
                    break;
                }
            }
        }
        return 0;
    }
    public int findClosestNumber(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int ret0 = Integer.MAX_VALUE, ret1 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (Math.abs(n) <= minValue) {
                minValue = Math.abs(n);
                if (n > 0 && n < ret0) {
                    ret0 = n;
                } else if (n > ret1) {
                    ret1 = n;
                }
            }
        }
        if (ret0 == Integer.MAX_VALUE) {
            return ret1;
        } else if (ret1 == Integer.MIN_VALUE) {
            return ret0;
        }
        return ret0 > Math.abs(ret1) ? ret1 : ret0;
    }
    
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < cost1 && total < cost2) {
            return 1;
        }
        long ret = 0;
        int tolCost1 = 0;
        while (tolCost1 <= total) {
            int tolCost2 = total - tolCost1;
            if (tolCost2 >= 0) {
                ret += tolCost2 / cost2 + 1;
            }
            tolCost1 += cost1;
        }
        return ret;
    }

    public static void main(String[] args) {
        new _1641_CountVowelStrings().waysToBuyPensPencils(5, 1, 1);
    }
}
