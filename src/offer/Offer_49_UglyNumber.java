package offer;

public class Offer_49_UglyNumber {
    public static void main(String[] args) {

    }

    public int nthUglyNumber(int n) {
        int[] uglys = new int[n + 1];
        uglys[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = uglys[p2] * 2, num3 = uglys[p3] * 3, num5 = uglys[p5] * 5;
            uglys[i] = Math.min(num2, Math.min(num3, num5));
            if (num2 == uglys[i]) {
                p2++;
            }
            if (num3 == uglys[i]) {
                p3++;
            }
            if (num5 == uglys[i]) {
                p5++;
            }
        }
        return uglys[n];
    }
}
