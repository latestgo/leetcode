package problem;

import java.util.Arrays;

/**
 * 元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 *
 * 示例 1：
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 */
public class _1838_MaxFrequency {
    // 超过时间限制
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int tmpRes = 1;
            int l = i - 1;
            int tmp = k;
            while (l >= 0) {
                tmp -= nums[i] - nums[l];
                if (tmp >= 0) {
                   tmpRes++;
                }
                l--;
            }
            if (tmpRes > res) {
                res = tmpRes;
            }
        }
        return res;
    }
    public int maxFrequency_1(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        int l = 0; // 左边边界
        for (int i = 1; i < nums.length; i++) {
            // 计算当前位置所需的 k
            while((nums[i] - nums[i - 1]) * (i - l) > k) {
                k += nums[i-1] - nums[l];
                l++;
            }
            k -= (nums[i] - nums[i - 1]) * (i - l);
            if (i - l + 1> res) {
                res = i - l + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1838_MaxFrequency offer = new _1838_MaxFrequency();
        int i = offer.maxFrequency(new int[]{1,2,4}, 5);
        System.out.println(i);
    }
}
