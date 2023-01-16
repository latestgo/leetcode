package problem;

import java.util.*;
import java.util.stream.Collectors;

public class _433_MinMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] genes = {'A', 'T', 'C', 'G'};
        Queue<String> q = new ArrayDeque<>();
        int step = 1;
        Set<String> set = Arrays.stream(bank).collect(Collectors.toSet());
        if (!set.contains(end)) {
            return -1;
        }
        q.add(start);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                StringBuilder sb = new StringBuilder(q.remove());
                for (int j = 0; j < sb.length(); j++) {
                    char c = sb.charAt(j);
                    for (char gene : genes) {
                        if (c != gene) {
                            sb.setCharAt(j, gene);
                            String str = sb.toString();
                            if (str.equals(end)) {
                                return step;
                            }
                            if (set.contains(str)) {
                                q.add(str);
                            }
                        }
                    }
                    sb.setCharAt(j, c);
                }
            }
            step++;
        }
        return -1;
    }
}
