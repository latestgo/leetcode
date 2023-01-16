package problem;

import java.util.Arrays;

public class _859_BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            int[] count = new int[26];
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                int ix = s.charAt(i) - 'a';
                count[ix]++;
                if (count[ix] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int a = -1, b = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (a < 0) {
                        a = i;
                    } else if (b < 0) {
                        b = i;
                    } else {
                        return false;
                    }
                }
            }
            return a >= 0 && b >= 0 && s.charAt(a) == goal.charAt(b) && s.charAt(b) == goal.charAt(a);
        }
    }
}
