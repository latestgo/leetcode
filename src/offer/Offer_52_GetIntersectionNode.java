package offer;

import util.ListNode;

import java.util.List;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class Offer_52_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        for (ListNode a = headA, b = headB; a != null || b != null;) {
            if (a != null) {
                lenA++;
                a = a.next;
            }
            if (b != null) {
                lenB++;
                b = b.next;
            }
        }
        int dif = lenA - lenB;
        ListNode a = dif > 0 ? headA : headB;
        ListNode b = dif > 0 ? headB : headA;
        dif = dif > 0 ? dif : -dif;
        while (a != null && b != null) {
            if (dif > 0) {
                a = a.next;
                dif --;
            } else {
                if (a == b) {
                    return a;
                } else {
                    a = a.next;
                    b = b.next;
                }
            }
        }
        return null;
    }
}
