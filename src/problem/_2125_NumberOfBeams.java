package problem;

public class _2125_NumberOfBeams {
    public int numberOfBeams(String[] bank) {
        int ret = 0;
        int last = 0;
        for (String line : bank) {
            String s = line.replaceAll("0", "");
            if (s.length() != 0) {
                ret += s.length() * last;
                last = s.length();
            }
        }
        return ret;
    }
}
