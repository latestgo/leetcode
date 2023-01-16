package offer;

import util.BinaryTree;
import util.TreeNode;

public class Offer_68_II_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode lson = lowestCommonAncestor(root.left, p, q);
        TreeNode rson = lowestCommonAncestor(root.right, p, q);
        if (lson != null && rson != null) {
            return root;
        } else if (lson != null) {
            return lson;
        } else if (rson != null) {
            return rson;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = BinaryTree.newBinaryTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        Offer_68_II_LowestCommonAncestor offer = new Offer_68_II_LowestCommonAncestor();
        TreeNode node = offer.lowestCommonAncestor(tree, new TreeNode(6), new TreeNode(2));
        if (node != null){
            System.out.println(node.val);
        } else {
            System.out.println("not find");
        }
    }
}
