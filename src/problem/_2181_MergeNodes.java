package problem;

import util.ListNode;

public class _2181_MergeNodes {
    public ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode zeroNode = null;
        ListNode lastZero = null;
        while (cur != null) {
            if (cur.val == 0 ) {
                if (zeroNode != null) {
                    zeroNode.next = cur;
                }
                lastZero = zeroNode;
                zeroNode = cur;
            } else {
                zeroNode.val += cur.val;
            }
            cur = cur.next;
        }
        lastZero.next = null;
        return head;
    }
}
