/**
 * Created by Administrator on 2014/7/20 0020.
 */
public class Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        ListNode newHead = null;

        while (null != p1) {
            p2 = p1.next;

            if (null != newHead && newHead.val == p1.val) {
                p1.next = null;
                p1 = p2;
                continue;
            }

            p1.next = newHead;
            newHead = p1;



        }

    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }
}