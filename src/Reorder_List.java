import util.ListNode;
import util.Utils;

/**
 * Created by Administrator on 2014/7/27 0027.
 */
public class Reorder_List {
    public void reorderList(ListNode head) {
        if (null == head) {
            return;
        }

        ListNode fast = head;
        ListNode mid = head;

        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            mid = mid.next;
        }

        ListNode reverseHead = mid;
        ListNode p2 = reverseHead.next;
        reverseHead.next = null;
        while (null != p2) {
            ListNode next = p2.next;
            p2.next = reverseHead.next;
            reverseHead.next = p2;
            p2 = next;
        }

        p2 = reverseHead.next;
        reverseHead.next = null;
        ListNode p1 = head;
        ListNode tail = null;
        while (null != p2) {
            ListNode next = p1.next;
            p1.next = p2;

            if (null == tail) {
                tail = p2;
            } else {
                tail.next = p1;
                tail = p2;
            }

            p2 = p2.next;
            p1 = next;
        }

        while (null != p1) {
            if (null == tail) {
                tail = p1;
            } else {
                tail.next = p1;
                tail = p1;
            }
            p1 = p1.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = Utils.genList(10);
        new Reorder_List().reorderList(head);
        Utils.printList(head);

        head = Utils.genList(11);
        new Reorder_List().reorderList(head);
        Utils.printList(head);
    }
}
