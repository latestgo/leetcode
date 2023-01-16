package problem;

public class _8_MyAtoi {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isBlank()) {
            return 0;
        }
        boolean negative = false;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.charAt(0) == '-') {
                negative = true;
            }
            str = str.substring(1);
        }
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            if (ret > Integer.MAX_VALUE / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (ret == Integer.MAX_VALUE / 10) {
                if (negative) {
                    if (c > '8') {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (c > '7') {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            ret = ret * 10 + Integer.parseInt(String.valueOf(c));
        }
        return negative? -ret : ret;
    }

}
