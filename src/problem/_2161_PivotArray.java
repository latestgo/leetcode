package problem;

import java.util.Arrays;

public class _2161_PivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ret = new int[nums.length];
        Arrays.fill(ret, pivot);
        int i = 0, j = nums.length - 1;
        for (int num : nums) {
            if (num < pivot) {
                ret[i++] = num;
            } else if (num > pivot) {
                ret[j--] = num;
            }
        }
        i = j + 1; j = nums.length - 1;
        while (i < j) {
            int t = ret[i];
            ret[i] = ret[j];
            ret[j] = t;
            i++;
            j--;
        }
        return ret;
    }
}
