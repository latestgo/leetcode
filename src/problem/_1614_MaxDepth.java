package problem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _1614_MaxDepth {
    public int maxDepth(String s) {
        int max = Integer.MIN_VALUE;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                c++;
            } else if (s.charAt(i) == ')') {
                c--;
            }
            max = Math.max(c, max);
            if (c < 0) {
                return 0;
            }
        }
        return max;
    }
}
