package offer;

import util.TreeNode;

public class Offer_55_1_MaxDepth {
    private int MAX = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        recur(root, 0);
        return MAX;
    }

    private void recur(TreeNode root, int d) {
        if (root != null) {
            recur(root.left, d + 1);
            recur(root.right, d + 1);
        } else {
            MAX = Math.max(MAX, d);
        }
    }
}
