import util.TreeNode;

/**
 * Created by Administrator on 2014/8/12 0012.
 */
public class Construct_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree_(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree_(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 >= end1 || start2 >= end2) {
            return null;
        }

        int rootVal = preorder[start1];
        int rootPos = start2;
        for (; rootPos < end2 && inorder[rootPos] != rootVal; ++rootPos);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree_(preorder, start1+1, start1+1+rootPos-start2, inorder, start2, rootPos);
        root.right = buildTree_(preorder, start1+1+rootPos-start2, end1, inorder, rootPos+1, end2);
        return root;
    }
}
