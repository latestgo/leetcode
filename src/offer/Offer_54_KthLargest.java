package offer;

import util.TreeNode;

public class Offer_54_KthLargest {

    private boolean valid = false;
    private int t = 0;
    private int ret = 0;

    public int kthLargest(TreeNode root, int k) {
        t = k;
        recur(root);
        return ret;
    }

    private void recur(TreeNode root) {
        if (root != null) {
            recur(root.right);
            if (!valid && root.right == null) {
                valid = true;
            }
            if (valid) {
                t --;
            }
            if (valid && t == 0){
                ret = root.val;
            }
            recur(root.left);
        }
    }
}
