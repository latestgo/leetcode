package util;

public class Test {
    public static void main(String[] args) {
        TreeNode treeNode = BinaryTree.newBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        BinaryTree.midTraverse(treeNode);
    }
}
