package util;

public class BinaryTree {
    public static TreeNode newBinaryTree(Integer nums[]) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != null) {
                nodes[i] = new TreeNode(nums[i]);
            } else {
                nodes[i] = null;
            }
        }
        for (int i = 0; i < nodes.length / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (nodes[i] != null) {
                nodes[i].left = nodes[left];
                nodes[i].right = nodes[right];
            }
        }
        return nodes[0];
    }

    public static void midTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            midTraverse(root.left);
            midTraverse(root.right);
        }
    }
}
