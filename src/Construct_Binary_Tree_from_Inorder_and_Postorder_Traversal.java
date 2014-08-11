import util.TreeNode;

/**
 * Created by Administrator on 2014/8/12 0012.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder) {
            return null;
        }

        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return buildInner(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildInner(int[] inorder, int start1, int end1,
                                int[] postorder, int start2, int end2) {
        if (start1 > end1 ) {
            return null;
        }

        int mid = postorder[end2];
        int midPos = 0;
        for (int i = start1; i <= end1; ++i) {
            if (mid == inorder[i]) {
                midPos = i;
                break;
            }
        }

        TreeNode root = new TreeNode(mid);
        int leftLen = midPos - start1;
        root.left = buildInner(inorder, start1, midPos - 1, postorder, start2, start2 + leftLen - 1);
        root.right = buildInner(inorder, midPos + 1, end1, postorder, start2 + leftLen, end2 - 1);
        return root;
    }
}
