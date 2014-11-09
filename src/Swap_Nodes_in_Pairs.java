import util.ListNode;

/**
 * Created by Administrator on 2014/10/25 0025.
 */
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (ListNode prev = dummy, stop = head; stop != null; stop = prev.next) {
            for (int i = 1; i < k && stop != null; ++i) {
                stop = stop.next;
            }

            if (null == stop) {
                break;
            }

            prev = reverse(prev, stop.next);
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode dummy, ListNode stop) {
        ListNode head = dummy.next;
        ListNode tail = head;
        dummy.next = stop;
        while (stop != head) {
            ListNode cur = head;
            head = head.next;
            cur.next = dummy.next;
            dummy.next = cur;
            if (head == tail) {
                tail = cur;
            }
        }

        return tail;
    }
}
