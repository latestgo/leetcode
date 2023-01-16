package problem;

import java.util.Arrays;

public class _209_MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length + 1; i++) {
            int s = sums[i - 1] + target;
            int index = Arrays.binarySearch(sums, s);
            if (index < 0) {
                index = -index - 1;
            }
            if (index <= nums.length) {
                ans = Math.min(ans, index - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int i = Arrays.binarySearch(new int[]{1, 3, 5}, 2);
        System.out.println(i);
    }
}
