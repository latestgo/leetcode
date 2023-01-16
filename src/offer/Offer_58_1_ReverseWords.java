package offer;

public class Offer_58_1_ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder buffer = new StringBuilder(s.length());
        int j = s.length() - 1, i = j;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            buffer.append(s, i + 1, j + 1).append(' ');
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return buffer.toString().trim();
    }

    public static void main(String[] args) {
        String s = new Offer_58_1_ReverseWords().reverseWords("  hello   world!  ");
        System.out.println(s);
    }
}
