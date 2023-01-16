package offer;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Offer_37_Codec {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 层次遍历
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append("|");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("#|");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isBlank()) {
            return null;
        }
        String[] arr = data.split("\\|");
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals("#")) {
                nodes[i] = new TreeNode(Integer.parseInt(String.valueOf(arr[i])));
            } else {
                nodes[i] = null;
            }
        }
        int i = 0;
        int pos = 1;
        while (i < arr.length) {
            if (nodes[i] != null) {
                nodes[i].left = nodes[pos++];
                nodes[i].right = nodes[pos++];
            }
            i++;
        }
        return nodes[0];
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("1|2|3|#|#|4|5|6|7|#|#|#|#|#|#|#|#|");
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);
    }
}
