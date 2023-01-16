package problem;

public class _942_DiStringMatch {
    public int[] diStringMatch(String s) {
        int min = 0, max = s.length();
        int[] ret = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ret[i] = min;
                min++;
            } else {
                ret[i] = max;
                max--;
            }
        }
        ret[s.length()] = min;
        return ret;
    }
}
