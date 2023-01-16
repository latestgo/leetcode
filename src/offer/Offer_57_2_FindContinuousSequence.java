package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer_57_2_FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ret = new ArrayList<>();
        for (int i = target; i >= 2; i--) {
            int value = target - (i * i - i) / 2;
            if (value % i == 0 && value > 0) {
                int init = value / i;
                int[] arr = new int[i];
                for (int j = 0; j < i; j++) {
                    arr[j] = init + j;
                }
                ret.add(arr);
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }

    public static void main(String[] args) {
        new Offer_57_2_FindContinuousSequence().findContinuousSequence(9);
    }
}
