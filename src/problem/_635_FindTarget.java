package problem;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _635_FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = root;
        if (root != null) {
            queue.add(node);
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right!= null) {
                queue.add(node.right);
            }
            if(dfs(root, k - node.val, node)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs (TreeNode root, int num, TreeNode node) {
        if (root != null) {
            if (root.val == num) {
                if (root == node) {
                    return false;
                }
                return true;
            } else if (root.val > num) {
                return dfs(root.left, num, node);
            } else {
                return dfs(root.right, num, node);
            }
        }
        return false;
    }
}
