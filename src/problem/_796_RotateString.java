package problem;

public class _796_RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.equals(goal)) {
            return true;
        }

        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String g = goal.substring(i, s.length()) + goal.substring(0, i);
            if (s.equals(g)) {
                return true;
            }
        }

        return false;
    }
}
