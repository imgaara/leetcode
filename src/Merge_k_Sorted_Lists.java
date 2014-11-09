import util.ListNode;
import util.Utils;

import java.util.*;

/**
 * O((N0*logk + N1*log(k-1) + Ni*log(k-i) + 1)   [N0<=N1<=N2...]
 * there is another way to do it (merger lists one be one): O(N0+N1+...)
 *
 * Created by www.imgaara.com on 2014/7/24 0024.
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(List<ListNode> lists) {
        TreeSet<ListNode> heap = new TreeSet<ListNode>((new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }));

        for (ListNode head : lists) {
            if (null != head) {
                heap.add(head);
            }
        }

        ListNode newHead = null;
        ListNode tail = null;
        while (!heap.isEmpty()) {
            ListNode curHead = heap.pollFirst();

            if (null == newHead) {
                newHead = curHead;
                tail = newHead;
            } else {
                tail.next = curHead;
                tail = tail.next;
            }

            if (null != curHead.next) {
                heap.add(curHead.next);
                curHead.next = null;
            }
        }

        return newHead;
    }


    public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = lists.get(0);
        for (int i = 1; i < lists.size(); ++i) {
            dummy.next = merge2(dummy.next, lists.get(i));
        }

        return dummy.next;
    }

    private ListNode merge2(ListNode l1, ListNode l2) {
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

        ListNode left = l1 == null ? l2 : l1;
        while (null != left) {
            tail.next = left;
            left = left.next;
            tail = tail.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Utils.printList(new Merge_k_Sorted_Lists().mergeKLists2(Arrays.asList(Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8), Utils.genList(2,4,6,8), Utils.genList(1,3,5,7), Utils.genList(2,4,6,8))));
    }
}
