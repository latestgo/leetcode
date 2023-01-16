package problem;

public class _693_HasAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        return (n & ((n ^ (n >> 1)) + 1)) == 0;
    }

    public static void main(String[] args) {
        new _693_HasAlternatingBits().hasAlternatingBits(5);
    }
}
