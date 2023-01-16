package problem;

import java.util.Arrays;

public class _312_MaxCoins {
    public int maxCoins(int[] nums) {
        int sum = 0;
        int ret = nums[0] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = nums[i] == 0 ? 1 : nums[i];
        }
        if (sum == 0) {
            return 0;
        }

        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        arr[0] = nums[0];
        arr[arr.length - 1] = nums[arr.length - 1];

        int l = 1;
        int r = arr.length - 2;
        boolean left = false;
        for (int i = 4; i <= arr.length; i += 2) {
            if (arr[l + 1] < arr[r - 1]) {
                arr[r] = nums[r];
                ret += arr[r - 1] * arr[r] * arr[r + 1];
                arr[l] = nums[l];
                ret += arr[l - 1] * arr[l] * arr[l + 1];
            } else {
                arr[l] = nums[l];
                ret += arr[l - 1] * arr[l] * arr[l + 1];
                arr[r] = nums[r];
                ret += arr[r - 1] * arr[r] * arr[r + 1];
            }
        }
        if (r - l > 1) {
            arr[l + 1] = nums[l + 1];
            ret += arr[l] * arr[l + 1] * arr[r];
        }
        return ret;
    }
}
