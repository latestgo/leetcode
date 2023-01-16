package offer;

public class Offer_65_Add {
    public static void main(String[] args) {
        System.out.println(new Offer_65_Add().add(1, -1));
    }
    public int add(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }
}
