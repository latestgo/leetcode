package problem;

public class _44_FindNthDigit {
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;
        while ( n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = start * digit * 9;
        }
        long num = start + (n - 1) / digit;
        return String.valueOf(num).charAt((n - 1) % digit) - '0';
    }
}
