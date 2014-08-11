import util.TreeLinkNode;

/**
 * Created by Administrator on 2014/8/11 0011.
 */
public class Populating_Next_Right_Pointers_in_Each_Node_II {
    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }

        TreeLinkNode tail = root;
        TreeLinkNode lastTail = root;
        TreeLinkNode cur = root;

        while (cur != null) {
            while (cur != lastTail.next) {
                if (null != cur.left) {
                    tail.next = cur.left;
                    tail = tail.next;
                }

                if (null != cur.right) {
                    tail.next = cur.right;
                    tail = tail.next;
                }

                cur = cur.next;
            }

            lastTail.next = null;
            lastTail = tail;
        }

        return;
    }
}
