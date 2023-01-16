package problem;

public class _809_ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        if (s.isBlank()) {
            return 0;
        }
        int ret = 0;
        for (String t : words) {
            ret += isExpressive(t, s);
        }
        return ret;
    }

    private int isExpressive(String s, String t) {
        int s1 = 0, s2 = 0;
        int t1 = 0, t2 = 0;
        while (s2 <= s.length()) {
            if (s2 == s.length() || s.charAt(s2) != s.charAt(s1)) {
                while (t2 < t.length() && t.charAt(t2) == s.charAt(s1)) {
                    t2++;
                }
                int slen = s2 - s1;
                int tlen = t2 - t1;
                if (slen != tlen && tlen < 3) {
                    return 0;
                }
                t1 = t2;
                s1 = s2;
            }
            s2++;
        }
        if (t2 == t.length()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        new _809_ExpressiveWords().isExpressive("dinnssoo", "dddiiiinnssssssoooo");
    }
}
