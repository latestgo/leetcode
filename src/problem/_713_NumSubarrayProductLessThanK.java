package problem;

public class _713_NumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0 , r = 0;
        if (k == 0 || k == 1) {
            return 0;
        }
        int sum = nums[0];
        int ret = 0;
        while (r < nums.length && l < nums.length) {
            if (sum < k) {
                ret += r - l + 1;

                r++;
                if (r < nums.length) {
                    sum *= nums[r];
                }
            } else {
                sum /= nums[l];
                l++;
            }
        }
        return ret;
    }
}
