package problem;

import java.util.HashMap;
import java.util.Map;

public class _1769_MinOperations {
    public int[] minOperations(String boxes) {
        if (boxes.isBlank()) {
            return new int[]{};
        }
        char[] boxArr = boxes.toCharArray();
        int[] ret = new int[boxArr.length];
        int right = 0, left = 0;
        if (boxArr[0] == '1') {
            left = 1;
        }
        for (int i = 1; i < boxArr.length; i++) {
            if (boxArr[i] == '1') {
                ret[0] += i;
                right++;
            }
        }

        for (int i = 1; i < boxArr.length; i++) {
            ret[i] = ret[i - 1] - right + left;
            if (boxArr[i] == '1') {
                right--;
                left++;
            }
        }
        return ret;
    }
}
