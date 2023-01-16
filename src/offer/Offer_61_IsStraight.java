package offer;

import java.util.Arrays;
import java.util.HashSet;

public class Offer_61_IsStraight {

    public boolean isStraight(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i != 0) {
                if (integers.contains(i)) {
                    return false;
                }
                if  (i < min) {
                    min = i;
                }
                if (i > max) {
                    max = i;
                }
                integers.add(i);
            }
        }
        return max - min < 5;
    }
}
