package offer;

public class Offer_58_ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        return s.substring(0, n) + s.substring(n);
    }
}
