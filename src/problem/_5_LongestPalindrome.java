package problem;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class _5_LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int st = 0, ed = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = find(s, i, i);
            int l2 = find(s, i, i + 1);
            int max = Math.max(l1, l2);
            if (ed - st < max) {
                st = i - ((max - 1) / 2);
                ed = i + max / 2;
            }
        }
        return s.substring(st, ed + 1);
    }

    private int find(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
