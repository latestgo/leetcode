package problem;

import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2130_PairSum {
    public int pairSum(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode postNode = head;
        deque.add(head.val);
        ListNode preNode = head.next;
        while (preNode.next != null) {
            postNode = postNode.next;
            preNode = preNode.next.next;
            deque.add(postNode.val);
        }
        postNode = postNode.next;
        int max = Integer.MIN_VALUE;
        while (postNode != null) {
            max = Math.max(max, deque.removeLast() + postNode.val);
            postNode = postNode.next;
        }
        return max;
    }
}
