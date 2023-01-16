package problem;

public class _1221_BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int ctI = 0, ctJ = 0;
        int ret = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                ctI++;
            } else {
                ctJ++;
            }
            if (ctJ > 0 && ctI == ctJ) {
                ctI = ctJ = 0;
                ret++;
            }
        }
        return ret;
    }
}
