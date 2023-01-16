package contest;

import java.util.*;

public class _293_Week {
    public List<String> removeAnagrams(String[] words) {
        String[] sorted = new String[words.length];
        List<String> ret = new ArrayList<>();
        ret.add(words[0]);
        for (int i = 0; i < words.length; i++) {
            char[] tmpW = words[i].toCharArray();
            Arrays.sort(tmpW);
            sorted[i] = String.valueOf(tmpW);
        }
        for (int i = 1; i < words.length; i++) {
            if (!sorted[i].equals(sorted[i - 1])) {
                ret.add(words[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new _293_Week().removeAnagrams(new String[]{"a", "b", "c"});
    }
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = 0;
        max = Math.max(special[0] - bottom, max);
        max = Math.max(top - special[special.length - 1], max);
        for (int i = 1; i < special.length; i++) {
            max = Math.max(special[i] - special[i - 1] - 1, max);
        }
        return max;
    }

    int maxLength = 0;
    public int largestCombination(int[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            if (i + maxLength >= candidates.length) {
                break;
            }
            dfs(candidates, candidates[i], i + 1, 1);
        }
        return maxLength;
    }

    private void dfs(int[] candidates, int num, int pos, int count) {
        maxLength = Math.max(maxLength, count);
        for (int i = pos; i < candidates.length; i++) {
            if ((num & candidates[i]) > 0) {
                dfs(candidates, num & candidates[i], i + 1, count + 1);
            }
        }
    }

    /**
     * 001
     * 010
     * 100
     * @param candidates
     * @return
     */
    public int largestCombination2(int[] candidates) {
        int num = 1;
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < 31; i++) {
            int tmp = 0;
            for (int j = 0; j < candidates.length; j++) {
                if ((candidates[j] & num) > 0) {
                    tmp++;
                }
            }
            ret = Math.max(ret, tmp);
            num <<= 1;
        }
        return ret;
    }
}
