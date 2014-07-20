import util.ListNode;
import util.Utils;

/**
 * Created by Administrator on 2014/7/20 0020.
 */
public class Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode newHead = null;
        ListNode tail = null;
        ListNode p1 = head;

        while (null != p1) {
            ListNode p2 = p1.next;
            while (null != p2 && p2.val == p1.val) {
                p2 = p2.next;
            }

            if (p1.next == p2) {
                p1.next = null;

                if (null == tail) {
                    tail = p1;
                    newHead = p1;
                } else {
                    tail.next = p1;
                    tail = tail.next;
                }
            }

            p1.next = null;
            p1 = p2;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = Utils.genList(1,2,2);
        Utils.printList(head);
        Utils.printList(new Remove_Duplicates_from_Sorted_List_II().deleteDuplicates(head));
    }

}