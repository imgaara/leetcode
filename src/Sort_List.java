import util.ListNode;

/**
 * Created by Administrator on 2014/8/13 0013.
 */
public class Sort_List {
    static class PartitionInfo {
        ListNode left;
        ListNode left2;
        ListNode right;
        ListNode right2;
        ListNode mid;
        ListNode mid2;

        PartitionInfo (ListNode left, ListNode left2, ListNode right, ListNode right2, ListNode mid, ListNode mid2) {
            this.left = left;
            this.left2 = left2;
            this.right = right;
            this.right2 = right2;
            this.mid = mid;
            this.mid2 = mid2;
        }
    }

    static class SortResult {
        ListNode start;
        ListNode end;
        SortResult(ListNode start, ListNode end) {
            this.start = start;
            this.end = end;
        }
    }

    public ListNode sortList(ListNode head) {
        if (null == head) {
            return null;
        }

        return sortListInner(head).start;
    }

    private SortResult sortListInner(ListNode head) {
        if (null == head) {
            return null;
        }

        PartitionInfo info = partition(head);
        if (null == info.left && null == info.right) {
            return new SortResult(info.mid, info.mid2);
        } else {
            SortResult left;
            SortResult right;
            if (info.left != null && info.left.val ==  info.mid.val && info.left2.val  == info.mid.val) {
                left = new SortResult(info.left, info.left2);
            } else {
                left = sortListInner(info.left);
            }

            if (info.right != null && info.right.val == info.mid.val && info.right2.val == info.mid.val) {
                right = new SortResult(info.right, info.right2);
            } else {
                right = sortListInner(info.right);
            }

            if (null != left) {
                left.end.next = info.mid;
            }

            if (null != right) {
                info.mid2.next = right.start;
            }

            return new SortResult(null != left ? left.start : info.mid, null != right ? right.end : info.mid2);
        }
    }

    private PartitionInfo partition(ListNode head) {
        if (null == head.next) {
            return new PartitionInfo(null, null, null, null, head, head);
        }

        ListNode l1 = null;
        ListNode l2 = null;

        ListNode p1 = null;
        ListNode p2 = null;

        ListNode i = head;
        ListNode p = i.next;
        i.next = null;
        ListNode p3 = i;

        while (null != p) {
            ListNode cur = p;
            p = p.next;
            cur.next = null;

            if (cur.val < i.val) {
                if (null == l1) {
                    l1 = cur;
                    p1 = l1;
                } else {
                    p1.next = cur;
                    p1 = cur;
                }

            } else if (cur.val > i.val){
                if (null == l2) {
                    l2 = cur;
                    p2 = l2;
                } else {
                    p2.next = cur;
                    p2 = cur;
                }
            } else {
                p3.next = cur;
                p3 = cur;
            }
        }

        return new PartitionInfo(l1, p1, l2, p2, i, p3);
    }

    private static ListNode arryToList(String[] arr) {
        ListNode last = null;
        for (int i = arr.length - 1; i >= 0; --i) {
            ListNode n = new ListNode(Integer.valueOf(arr[i]));
            n.next = last;
            last = n;
        }

        return last;
    }
}
