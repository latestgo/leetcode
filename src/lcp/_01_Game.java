package lcp;

public class _01_Game {
    public int game(int[] guess, int[] answer) {
        int ret = 0;
        for (int i = 0; i < guess.length; i++) {
            ret += guess[i] == answer[i] ? 1 : 0;
        }
        return ret;
    }
}
