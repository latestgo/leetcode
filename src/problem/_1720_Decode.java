package problem;

public class _1720_Decode {
    public int[] decode(int[] encoded, int first) {
        int[] ret = new int[encoded.length + 1];
        ret[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            ret[i+1] = ret[i] ^ encoded[i];
        }
        return ret;
    }
}
