package problem;

import util.BinaryTree;
import util.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 */
public class _671_FindSecondMinimumValue {
    int ans = -1;
    int rootVal = -1;
    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val > rootVal && (ans == -1 || node.val < ans)) {
            ans = node.val;
        }
        if (node.val > rootVal) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        _671_FindSecondMinimumValue findSecondMinimumValue = new _671_FindSecondMinimumValue();
        TreeNode root = BinaryTree.newBinaryTree(new Integer[]{1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1});
        int i = findSecondMinimumValue.findSecondMinimumValue(root);
        System.out.println(i);
    }
}
