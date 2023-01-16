package offer;

import java.util.ArrayList;

public class Offer_59_1_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int slideIndex = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= nums[slideIndex]) {
                slideIndex = i;
            }
        }
        res[0] = nums[slideIndex];
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= nums[slideIndex]) {
                slideIndex = i;
            } else {
                if (slideIndex <= i - k) {
                    slideIndex = i;
                    for (int j = i - k + 1; j <= i; j++) {
                        if (nums[j] >= nums[slideIndex]) {
                            slideIndex = j;
                        }
                    }
                }
            }
            res[i - k + 1] = nums[slideIndex];
        }
        return res;
    }
}
