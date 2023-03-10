package interview;

import java.util.HashMap;
import java.util.Map;

public class Interview_50_FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (!map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
