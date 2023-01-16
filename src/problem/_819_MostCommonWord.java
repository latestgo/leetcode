package problem;

import java.util.*;
import java.util.stream.Collectors;

public class _819_MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = Arrays.stream(banned)
                                   .collect(Collectors.toSet());
        Map<String, Integer> map = new HashMap<>();
        int last = 0;
        String maxString = "";
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c < 'A' || c > 'z' || i == paragraph.length() - 1) {
                while (last < paragraph.length() && (paragraph.charAt(last) > 'z' || paragraph.charAt(last) < 'A')) {
                    last++;
                }
                if (last < i) {
                    String s = paragraph.substring(last, i).toLowerCase();
                    if (i == paragraph.length() - 1 && paragraph.charAt(i) <= 'z' && paragraph.charAt(i) >= 'A') {
                        s = paragraph.substring(last, i + 1).toLowerCase();
                    }
                    if (!banSet.contains(s) && !s.isBlank()) {
                        map.put(s, map.getOrDefault(s, 0) + 1);
                        if (map.get(s) > maxCount) {
                            maxString = s;
                            maxCount = map.get(s);
                        }
                    }
                }
                last = i;
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        new _819_MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. Bob hit a ball, the hit BALL flew far after it was hit. ", new String[]{"hit"});
    }
}
