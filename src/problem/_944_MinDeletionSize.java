package problem;

public class _944_MinDeletionSize {
    public int minDeletionSize(String[] strs) {
        int ret = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }
}
