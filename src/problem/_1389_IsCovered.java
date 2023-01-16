package problem;

import java.util.Arrays;

/**
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。
 * 每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 *
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，
 * 那么请你返回 true ，否则返回 false 。
 *
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，
 * 那么我们称整数x 被覆盖了。
 * 示例 1：
 *
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 */
public class _1389_IsCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // find min start and max end
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] < min) {
                min = ranges[i][0];
            }
            if (ranges[i][1] > max) {
                max = ranges[i][1];
            }
        }
        boolean[] bucket = new boolean[max - min + 1];
        Arrays.fill(bucket, false);
        for (int i = 0; i< ranges.length; i++) {
            Arrays.fill(bucket, ranges[i][0] - min, ranges[i][1] - min + 1, true);
        }
        for (int i = left; i <= right; i++) {
            if (i < min || i > max || !bucket[i - min]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _1389_IsCovered isCovered = new _1389_IsCovered();
        isCovered.isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5);
    }
}
