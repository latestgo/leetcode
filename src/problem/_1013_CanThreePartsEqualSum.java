package problem;

import java.util.Arrays;

public class _1013_CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0){
            return false;
        }
        int ix = 0;
        int tmpSum = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            tmpSum += arr[i];
            ix = i;
            if (tmpSum == sum / 3) {
                break;
            }
        }
        tmpSum = 0;
        for (int i = ix + 1; i < arr.length - 1; i++) {
            tmpSum += arr[i];
            if (tmpSum == sum / 3) {
                return true;
            }
        }
        return false;
    }
}
