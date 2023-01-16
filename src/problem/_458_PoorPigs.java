package problem;

public class _458_PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int count = minutesToTest / minutesToDie;
        int base = count + 1;
        return (int)Math.ceil(Math.log(buckets) / Math.log(base));
    }
}
