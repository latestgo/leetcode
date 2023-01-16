package problem;

public class _1689_MinPartitions {
    public int minPartitions(String n) {
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            ret = Math.max(ret, n.charAt(i) - '0');
        }
        return ret;
    }
}
