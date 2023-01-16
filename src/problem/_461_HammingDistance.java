package problem;

public class _461_HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance1(int x, int y) {
        int ret = 0, s = x ^ y;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

}
