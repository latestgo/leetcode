package problem;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _2160_MinimumSum {
    public int minimumSum(int num) {
        int[] ints = new int[4];
        ints[0] = num % 10;
        num /= 10;
        ints[1] = num % 10;
        num /= 10;
        ints[2] = num % 10;
        num /= 10;
        ints[3] = num % 10;
        Arrays.sort(ints);
        return ints[0] * 10 + ints[2] + ints[1] * 10 + ints[3];
    }
}
