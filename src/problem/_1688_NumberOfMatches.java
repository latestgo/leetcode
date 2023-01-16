package problem;

public class _1688_NumberOfMatches {
    public int numberOfMatches(int n) {
        int ret = 0;
        while (n > 1) {
            ret += n / 2;
            n = n / 2 + n % 2;
        }
        return  ret;
    }
}
