package problem;

import util.ListNode;

public class _25_ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k);
    }

    private ListNode reverse(ListNode head, int k) {
        int i = 0;
        ListNode node = head;
        ListNode end = head;
        ListNode nextGroupHead = null;
        while (node != null) {
            i++;
            end = node;
            node = node.next;
            if (i == k) {
                nextGroupHead = reverse(node, k);
                break;
            }
        }
        if (i < k) {
            return head;
        }

        ListNode beforeNode = null;
        node = head;
        ListNode nextNode;
        while (node != end && node != null) {
            nextNode = node.next;
            node.next = beforeNode;
            beforeNode = node;
            node = nextNode;
        }
        node.next = beforeNode;
        head.next =  nextGroupHead;
        return node;
    }
}
