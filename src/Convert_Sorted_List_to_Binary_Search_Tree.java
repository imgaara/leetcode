import util.ListNode;
import util.TreeNode;

/**
 * Created by Administrator on 2014/8/12 0012.
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    static class Wrapper {
        public ListNode list;
        public Wrapper(ListNode list) {this.list = list;}
    }

    public TreeNode sortedListToBST(ListNode head) {
        int N = getLength(head);
        return toBST(new Wrapper(head), 0, N - 1);
    }

    private int getLength(ListNode list) {
        int count = 0;
        while (null != list) {
            ++count;
            list = list.next;
        }

        return count;
    }

    private TreeNode toBST(final Wrapper wrapper, final int start, final int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = toBST(wrapper, start, mid - 1);
        TreeNode parent = new TreeNode(wrapper.list.val);
        parent.left = left;
        wrapper.list = wrapper.list.next;
        parent.right = toBST(wrapper, mid + 1, end);
        return parent;
    }
}
