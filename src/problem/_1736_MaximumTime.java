package problem;

/**
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 * 示例 1：
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 */
public class _1736_MaximumTime {
    public String maximumTime(String time) {
        char[] array = time.toCharArray();
        if (array[0] == '?') {
            if (array[1] > '3' && array[1] != '?') {
                array[0] = '1';
            } else {
                array[0] = '2';
            }
        }
        if (array[1] == '?') {
            if (array[0] < '2') {
                array[1] = '9';
            } else {
                array[1] = '3';
            }
        }
        if (array[3] == '?') {
            array[3] = '5';
        }
        if (array[4] == '?') {
            if (array[3] < '6') {
                array[4] = '9';
            } else {
                array[4] = '0';
            }
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        _1736_MaximumTime maximumTime = new _1736_MaximumTime();
        String s = maximumTime.maximumTime("2?:?9");
        System.out.println(s);
    }
}
