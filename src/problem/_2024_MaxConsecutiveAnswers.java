package problem;

public class _2024_MaxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(max(answerKey, k, 'T'), max(answerKey, k, 'F'));
    }

    private int max(String answerKey, int k, char target) {
        int i = 0, j = 0, c = 0;
        int max = Integer.MIN_VALUE;
        for (j = 0; j < answerKey.length(); j++) {
            if (answerKey.charAt(j) != target) {
                c++;
            }
            while (c > k) {
                if (answerKey.charAt(i) != target) {
                    c--;
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
