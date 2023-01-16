package offer;

public class Offer_56_1_SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int orValue = 0;
        for (int n: nums) {
            orValue ^= n;
        }
        int m = 1;
        while ((orValue & m) != 1) {
            m <<= 1;
        }
        int firstValue = 0, secondValue = 0;
        for (int n: nums) {
            if ((n & m) == 0) {
                firstValue ^= n;
            } else {
                secondValue ^= n;
            }
        }
        return new int[]{firstValue, secondValue};
    }
}
