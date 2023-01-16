package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class _682_CalPoints {
    public int calPoints(String[] ops) {
        List<Integer> pt = new ArrayList<>();
        for (String op: ops) {
            if (Objects.equals(op, "C")) {
                pt.remove(pt.size() - 1);
            } else if (Objects.equals(op, "D")) {
                pt.add(pt.get(pt.size() - 1) * 2);
            } else if (Objects.equals(op, "+")) {
                pt.add(pt.get(pt.size() - 1) + pt.get(pt.size() - 2));
            } else {
                pt.add(Integer.valueOf(op));
            }
        }
        return pt.stream().mapToInt(i -> i) .sum();
    }
}
