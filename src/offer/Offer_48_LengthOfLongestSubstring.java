package offer;

import java.util.HashMap;

public class Offer_48_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int max = 1;
        int[] dp = new int[s.length()]; dp[0] = 1;
        charIndexMap.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            int lastChar = charIndexMap.getOrDefault(s.charAt(i), -1);
            if (dp[i-1] < i - lastChar) {
                dp[i] =  dp[i-1] + 1;
            } else {
                dp[i] = i - lastChar;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
            charIndexMap.put(s.charAt(i), i);
        }
        return max;
    }
}
