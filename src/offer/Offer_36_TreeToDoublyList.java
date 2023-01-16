package offer;

public class Offer_36_TreeToDoublyList {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void recur(Node node) {
        if (node == null) {
            return ;
        }
        recur(node.left);
        if (pre != null) {
            pre.right = node;
            node.left = pre;
        } else {
            head = node;
        }
        pre = node;
        recur(node.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
