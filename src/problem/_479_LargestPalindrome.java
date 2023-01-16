package problem;

public class _479_LargestPalindrome {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int end = (int) (Math.pow(10, n) - 1);
        for (int i = end; i > 9 ; i--) {
            String endStr = String.valueOf(i);
            String palindrome = endStr + new StringBuilder(endStr).reverse();
            long pali = Long.parseLong(palindrome);
            int x = end;
            while ((long) x * x >= pali) {
                if (pali % x == 0) {
                    return (int) (pali % 1337);
                }
                x--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new _479_LargestPalindrome().largestPalindrome(2);
    }
}
