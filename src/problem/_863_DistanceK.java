package problem;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 */
public class _863_DistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, TreeNode> map = new HashMap<>();
        dfs(root, null, map, target);
        List<Integer> res = new ArrayList<>();
        findChild(target, null, map, res, k);
        return res;
    }

    private void findChild(TreeNode root, TreeNode from, Map<Integer, TreeNode> map, List<Integer> list, int k) {
        if (root == null || root == from) {
            return ;
        }
        if (k == 0) {
            list.add(root.val);
            return;
        }
        if (root.left != from) {
            findChild(root.left, root, map, list, k-1);
        }
        if (root.right != from) {
            findChild(root.right, root, map, list, k-1);
        }
        if (map.containsKey(root.val)) {
            TreeNode p = map.get(root.val);
            if (p != from) {
                findChild(map.get(root.val),root, map, list, k-1);
            }
        }
    }
    private void dfs(TreeNode root, TreeNode from, Map<Integer, TreeNode> map, TreeNode target) {
        if (root == null) {
            return ;
        }
        if (from != null) {
            map.put(root.val, from);
        }
        if (root == target) {
            return;
        }
        dfs(root.right, root, map, target);
        dfs(root.left, root, map, target);
    }

    public static void main(String[] args) {
        _863_DistanceK k = new _863_DistanceK();
        TreeNode node1 = new TreeNode(0);

        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        node1.left = node2; node1.right = node3;

        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        node2.left = node4; node2.right = node5;

        TreeNode node6= new TreeNode(7);
        TreeNode node7= new TreeNode(4);
        node4.left = node6; node4.right = node7;

        TreeNode node8 = new TreeNode(5);
        node7.right = node8;
        List<Integer> integers = k.distanceK(node1, node2, 3);
        System.out.println(integers);
    }
    public static void main1(String[] args) {
        _863_DistanceK distanceK = new _863_DistanceK();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.left = node8;
        node5.right = node9;
        List<Integer> integers = distanceK.distanceK(node1, node2, 2);
        System.out.println(integers.toString());
    }
}
