package problem;

import java.util.ArrayList;
import java.util.List;

public class _2194_CellsInRange {
    public List<String> cellsInRange(String s) {
        List<String> ret = new ArrayList<>();
        for (char i = s.charAt(0); i <= s.charAt(3); i++) {
            for (char j = s.charAt(1); j <= s.charAt(4); j++) {
                ret.add(i + String.valueOf(j));
            }
        }
        return ret;
    }
}
