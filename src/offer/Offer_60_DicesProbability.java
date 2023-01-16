package offer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Offer_60_DicesProbability {
    public double[] dicesProbability(int n) {
        int[] valueTmp = new int[70];
        int[] value = new int[70];
        double[] ret = new double[5*n + 1];
        Arrays.fill(valueTmp, 1, 7, 1);
        Arrays.fill(value, 1, 7, 1);
        for (int i = 2; i <= n; i++) {
            for (int j = i ; j <= 6 * i; j++) {
                value[j] = 0;
                for (int k = 1; k <= 6; k++) {
                    if (j > k && j - k >= i - 1) {
                        value[j] += valueTmp[j - k];
                    }
                }
            }
            System.arraycopy(value, 0, valueTmp, 0, 70);
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] = value[(n + i)] * 1.0 / Math.pow(6, n);
        }
        return ret;
    }

    public static void main(String[] args) {
        double[] doubles = new Offer_60_DicesProbability().dicesProbability(3);
        System.out.println(Arrays.toString(doubles));
    }
}
