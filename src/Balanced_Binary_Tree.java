import util.TreeNode;

/**
 * Created by www.imgaara.com on 2014/9/17 0017.
 */
public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    private int getHeight(TreeNode p) {
        if (p == null) {
            return 0;
        }

        int l = getHeight(p.left);
        int r = getHeight(p.right);
        if (l == -1 || r == -1) {
            return -1;
        }

        if (Math.abs(l - r) > 1) {
            return -1;
        }

        return Math.max(l, r) + 1;
    }
}
