package interview;

import util.ListNode;

public class Interview_02_03_DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        System.out.println(~1);
    }
}
