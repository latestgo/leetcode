package problem;

import java.util.Arrays;

public class _1877_MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = Integer.MIN_VALUE;
        int len = nums.length - 1;
        for (int i = 0; i <= len / 2; i++) {
            int s = nums[i] + nums[len - i];
            if (s > sum) {
                sum = s;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        _1877_MinPairSum off = new _1877_MinPairSum();
        int i = off.minPairSum(new int[]{3,5,4,2,4,6});
        System.out.println(i);
    }
}
