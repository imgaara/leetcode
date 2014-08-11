import util.TreeNode;

/**
 * Created by Administrator on 2014/8/12 0012.
 */
public class Validate_Binary_Search_Tree {
    static class Helper {
        int min;
        int max;
        boolean isValid;
        public Helper(int min, int max, boolean isValid) {
            this.min = min;
            this.max = max;
            this.isValid = isValid;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }

        Helper r = isValidBST_(root);
        return r.isValid;
    }

    private Helper isValidBST_(TreeNode root) {
        if (null == root) {
            return null;
        }

        if (null == root.left && null == root.right) {
            return new Helper(root.val, root.val, true);
        }

        Helper left = isValidBST_(root.left);
        if (null != left) {
            if (!left.isValid || left.max >= root.val) {
                return new Helper(0, 0, false);
            }
        }


        Helper right = isValidBST_(root.right);
        if (null != right) {
            if (!right.isValid || right.min <= root.val) {
                return new Helper(0, 0, false);
            }
        }

        return new Helper(left == null ? root.val : left.min, right == null ? root.val : right.max, true);
    }
}
