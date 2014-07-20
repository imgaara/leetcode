package util;

/**
 * Created by Administrator on 2014/7/20 0020.
 */
public class Utils {
    public static void printList(ListNode head) {
        while (null != head) {
            System.out.print(head.val);
            System.out.print(',');
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode genList(int needNum) {
        ListNode head = new ListNode(0, null);
        ListNode tail = head;
        for (int i = 1; i < needNum; ++i) {
            tail.next = new ListNode(i, null);
            tail = tail.next;
        }

        return head;
    }

    public static ListNode genList(int ... args) {
        assert(args.length > 0);
        ListNode head = new ListNode(args[0], null);
        ListNode tail = head;
        for (int i = 1; i < args.length; ++i) {
            tail.next = new ListNode(args[i], null);
            tail = tail.next;
        }

        return head;
    }
}
