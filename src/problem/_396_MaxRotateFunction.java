package problem;

public class _396_MaxRotateFunction {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int max = 0;
        if (nums.length == 1) {
            return 0;
        }
        for (int n : nums) {
            sum += n;
        }
        for (int i = 0; i < nums.length; i++) {
            max += i * nums[i];
        }
        int sumF = max;
        for (int i = nums.length - 1; i > 0; i--) {
            sumF = sumF + sum - nums.length * nums[i];
            max = Math.max(max, sumF);
        }
        return max;
    }
    public int maxRotateFunction1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                tmp += j * nums[(i + j) % nums.length];
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}
