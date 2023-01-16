package problem;

import java.util.ArrayList;
import java.util.List;

public class _386_LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);
        for (int i = 1; i < n; i++) {
            int last = ret.get(ret.size() - 1);
            if (last * 10 <= n) {
                ret.add(last * 10);
            } else if (last % 10 == 9 || last + 1 > n){
                last /= 10;
                while (last % 10 == 9 || last + 1 > n) {
                    last /= 10;
                }
                ret.add(last + 1);
            } else {
                ret.add(last + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new _386_LexicalOrder().lexicalOrder(192);
    }
}
