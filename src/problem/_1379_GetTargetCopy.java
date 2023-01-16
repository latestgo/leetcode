package problem;

import util.TreeNode;

public class _1379_GetTargetCopy {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned != null) {
            if (cloned.val == target.val) {
                return cloned;
            }
            TreeNode node = getTargetCopy(original, cloned.left, target);
            if (node != null) {
                return node;
            }
            node = getTargetCopy(original, cloned.right, target);
            return node;
        }
        return null;
    }
}
