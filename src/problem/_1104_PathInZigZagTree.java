package problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1104_PathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        int i = 1;
        while ((1 << i) - 1 < label) {
            i++;
        }
        while (i > 0) {
            list.add(label);
            int currBegin = 1 << (i - 1);
            int currEnd = (1 << i) - 1;

            // 偶数层
            if (i % 2 == 0) {
                label = currEnd - (label - currBegin);
            } else {
                label = currBegin + (currEnd - label);
            }
            label /= 2;
            i--;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        _1104_PathInZigZagTree pathInZigZagTree = new _1104_PathInZigZagTree();
        List<Integer> i = pathInZigZagTree.pathInZigZagTree(14);
        System.out.println(i);
    }
}
