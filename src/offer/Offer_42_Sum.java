package offer;

public class Offer_42_Sum {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer_42_Sum offer = new Offer_42_Sum();
        int i = offer.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

}
