import util.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

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
}
