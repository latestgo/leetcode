package offer;

public class Offer_57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s == target) {
                return new int[]{nums[i], nums[j]};
            } else if (s < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{ };
    }
}
