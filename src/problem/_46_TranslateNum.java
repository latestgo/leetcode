package problem;

public class _46_TranslateNum {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        if (str.length() < 1) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        int[] dp = new int[str.length()];
        dp[0] = 1;
        if (Integer.parseInt(str.substring(0, 2)) < 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < str.length(); i++) {
            dp[i] = dp[i - 1];
            if (str.charAt(i - 1) != '0' && Integer.parseInt(str.substring(i - 1, i + 1)) < 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[str.length() - 1];
    }

    public static void main(String[] args) {
        new _46_TranslateNum().translateNum(506);
    }
}
