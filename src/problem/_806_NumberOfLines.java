package problem;

public class _806_NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int MAX_LENGTH = 100;
        int currentLen = 0;
        int line = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int pt = c - 'a';
            if (currentLen + widths[pt] <= MAX_LENGTH) {
                currentLen += widths[pt];
            } else {
                line++;
                currentLen = widths[pt];
            }
        }
        return new int[]{line, currentLen};
    }
}
