package offer;

public class Offer_62_LastRemainging {
    public int lastRemaining(int n, int m) {
        int k = 0;
        for (int i = 2; i <= n; i++) {
            k = (k + m) % i;
        }
        return k;
    }

    public static void main(String[] args) {
        Offer_62_LastRemainging offer = new Offer_62_LastRemainging();
        int i = offer.lastRemaining(5, 3);
        System.out.println(i);
    }
}
