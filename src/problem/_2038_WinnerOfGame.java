package problem;

public class _2038_WinnerOfGame {
    public boolean winnerOfGame(String colors) {
        int[] res = new int[2];
        int time = 0;
        char cur = 'C';
        for (int i = 0; i < colors.length(); i++) {
            char ch = colors.charAt(i);
            if (ch != cur) {
                cur = ch;
                time = 1;
            } else {
                time++;
                if (time >= 3) {
                    res[cur - 'A'] += 1;
                }
            }
        }
        return res[0] > res[1];
    }
}
