package problem;

import java.util.ArrayList;
import java.util.List;

public class _728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelf(i)) {
                ret.add(i);
            }
        }
        return ret;
    }

    private boolean isSelf(int v) {
        int div = v;
        while (div != 0) {
            int remainder = div % 10;
            if (remainder != 0) {
                if(v % remainder != 0) {
                    return false;
                }
            } else {
                return false;
            }
            div = div / 10;
        }
        return true;
    }
}
