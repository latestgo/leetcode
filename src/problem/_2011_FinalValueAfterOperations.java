package problem;

public class _2011_FinalValueAfterOperations {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String s : operations) {
            if (s.contains("+")) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
