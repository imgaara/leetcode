import util.ListNode;
import util.Utils;

/**
 * Created by zero on 14-7-19.
 */
public class Reverse_Nodes_in_k_Group {
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

    public static void main(String[] args) {
        Utils.printList(new Reverse_Nodes_in_k_Group().reverseKGroup(Utils.genList(10), 3));
    }
}
