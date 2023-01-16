package problem;

public class _821_ShortestToChar {
    public int[] shortestToChar(String s, char c) {
        int left =  -s.length();
        int[] ret = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                ret[i] = 0;
                left = i;
            } else {
                ret[i] = i - left;
            }
        }
        int right = 2 * s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != c) {
                ret[i] = Math.min(right - i, ret[i]);
            } else {
                right = i;
            }
        }
        return ret;
    }
}
