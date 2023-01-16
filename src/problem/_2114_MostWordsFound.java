package problem;

public class _2114_MostWordsFound {
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String s: sentences) {
            int l = s.split(" ").length;
            max = Math.max(max, l);
        }
        return max;
    }
}
