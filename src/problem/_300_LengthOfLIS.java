package problem;

import java.util.Arrays;

public class _300_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j  = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = new _300_LengthOfLIS().lengthOfLIS(nums);
        System.out.println(i);
    }
}
