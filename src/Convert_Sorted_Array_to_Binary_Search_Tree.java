import util.TreeNode;

/**
 * Created by Administrator on 2014/8/12 0012.
 */
public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] num) {
        return toBST(num, 0, num.length - 1);
    }

    private TreeNode toBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode p = new TreeNode(num[mid]);
        p.left = toBST(num, start, mid - 1);
        p.right = toBST(num, mid + 1, end);

        return p;
    }
}
