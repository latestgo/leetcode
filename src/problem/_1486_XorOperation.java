package problem;

public class _1486_XorOperation {
    public int xorOperation(int n, int start) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret ^= start + 2 * i;
        }
        return ret;
    }
}
