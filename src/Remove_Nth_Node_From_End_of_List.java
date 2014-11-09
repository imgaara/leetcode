import util.ListNode;
import util.Utils;

/**
 * Created by Administrator on 2014/10/25 0025.
 */
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;
        for (; null != end && n > 0; end = end.next, n--) {
        }

        if (n > 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = prev.next;
        for (; null != end; prev = cur, cur = prev.next, end = end.next) {
        }

        if (null != cur) {
            prev.next = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Utils.printList(new Remove_Nth_Node_From_End_of_List().removeNthFromEnd(Utils.genList(1, 2), 1));
    }
}
