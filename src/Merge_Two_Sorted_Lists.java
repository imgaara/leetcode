import util.ListNode;

/**
 * Created by Administrator on 2014/8/13 0013.
 */
public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }

        if (null == l2) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for (; null != l1 && null != l2; p = p.next) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }

        p.next = null == l1 ? l2 : l1;
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        ListNode left = (l1 == null ? l2 : l1);
        while (null != left) {
            tail.next = left;
            left = left.next;
            tail = tail.next;
        }

        return dummy.next;
    }
}
