/**
 * Created by zero on 14-7-19.
 */
public class Reverse_Nodes_in_k_Group {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Helper {
        ListNode head;
        ListNode tail;

        public Helper(final ListNode head, final ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public ListNode reverseKGroup(ListNode head, final int k) {
        if (null == head || head.next == null || k == 1) {
            return head;
        }

        Helper helper = new Helper(head, null);
        Helper lastHelper = null;
        ListNode newHead = null;

        while (null != head) {
            helper = reverseKGroup_(head, k);
            if (helper.tail == null) {
                break;
            }

            if (newHead == null) {
                newHead = helper.head;
            }

            if (null != lastHelper) {
                lastHelper.tail.next = helper.head;
            }

            head = helper.tail.next;
            lastHelper = helper;
        }

        return newHead;
    }

    private Helper reverseKGroup_(ListNode head, final int k) {
        ListNode p1 = head;
        ListNode newHead = null;
        ListNode lastTail = null;
        int count = k;

        while (count-- > 0 && null != p1) {
            ListNode p2 = p1.next;

            p1.next = newHead;
            newHead = p1;

            if (null == lastTail) {
                lastTail = p1;
            }
            lastTail.next = p2;

            p1 = p2;
        }

        if (count >= 0) {
            p1 = newHead;
            newHead = null;
            lastTail = null;
            while (null != p1) {
                ListNode p2 = p1.next;
                p1.next = newHead;
                newHead = p1;

                if (null == lastTail) {
                    lastTail = p1;
                }
                lastTail.next = p2;

                p1 = p2;
            }
        }

        return new Helper(newHead, lastTail);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, null);
        ListNode tail = head;
        for (int i = 1; i < 2; ++i) {
            tail.next = new ListNode(i, null);
            tail = tail.next;
        }

        printList(new Reverse_Nodes_in_k_Group().reverseKGroup(head, 3));
    }

    private static void printList(ListNode head) {
        while (null != head) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
