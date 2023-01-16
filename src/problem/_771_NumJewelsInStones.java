package problem;

public class _771_NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        int ret = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
