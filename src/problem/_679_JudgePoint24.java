package problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class _679_JudgePoint24 {
    private static final double EPSILON = 1e-6;
    private static final int TARGET = 24;
    private static final int ADD = 0, TIMES = 1, SUBTRACT = 2, DIVIDE = 3;
    public boolean judgePoint24(int[] cards) {
        int[] visited = new int[]{0, 0, 0, 0};
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            list.add((double) cards[i]);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j ) {
                    continue;
                }
                List<Double> list2 = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != j && k != i) {
                        list2.add(list.get(k));
                    }
                }

                for (int k = 0; k < 4; k++) {
                    if (k < 2 && i > j) {
                        continue;
                    }
                    if (k == ADD) {
                        list2.add(list.get(i) + list.get(j));
                    } else if (k == TIMES) {
                        list2.add(list.get(i) * list.get(j));
                    } else if (k == SUBTRACT) {
                        list2.add(list.get(i) - list.get(j));
                    } else {
                        if (!(Math.abs(list.get(j)) < EPSILON)) {
                            list2.add(list.get(i) / list.get(j));
                        } else {
                            continue;
                        }
                    }
                    if (dfs(list2)) {
                        return true;
                    }
                    list2.remove(list2.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new _679_JudgePoint24().judgePoint24(new int[]{1, 2, 1, 2});
        System.out.println(b);
    }
}
