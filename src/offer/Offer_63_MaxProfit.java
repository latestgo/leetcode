package offer;

public class Offer_63_MaxProfit {
    public int maxProfit(int[] prices) {
        int mix = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < mix) {
                mix = prices[i];
            }
            if (res < prices[i] - mix) {
                res = prices[i] - mix;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer_63_MaxProfit offer = new Offer_63_MaxProfit();
        int i = offer.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
