package offer;

public class Offer_53_MissingNumber {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (m == nums[m]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
