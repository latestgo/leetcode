package problem;

public class _1920_BuildArray {
    public int[] buildArray(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[nums[i]];
        }
        return ret;
    }
}
