package problem;

public class _1929_GetConcatenation {
    public int[] getConcatenation(int[] nums) {
        int[] ret = new int[nums.length * 2];
        System.arraycopy(nums, 0, ret, 0, nums.length);
        System.arraycopy(nums, 0, ret, nums.length, nums.length);
        return ret;
    }
}
