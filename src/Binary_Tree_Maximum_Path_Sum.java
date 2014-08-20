import util.TreeNode;

/**
 * Created by Administrator on 2014/8/13 0013.
 */
public class Binary_Tree_Maximum_Path_Sum {
    static class Helper {
        int val;

        Helper(int val) {this.val = val;}
    }

    public int maxPathSum(TreeNode root) {
        Helper max = new Helper(Integer.MIN_VALUE);
        maxPathSum_(root, max);

        return max.val;
    }

    public int maxPathSum_(TreeNode root, Helper max) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            if (root.val > max.val) {
                max.val = root.val;
            }
            return root.val;
        }

        int left = maxPathSum_(root.left, max);
        int right = maxPathSum_(root.right, max);
        int all = root.val;
        if (left > 0) {
            all += left;
        }

        if (right > 0) {
            all += right;
        }

        max.val = max(max.val, all);

        return max(left + root.val, right + root.val, root.val);
    }

    private int max(int ... a) {
        int max = Integer.MIN_VALUE;
        for (int cur : a) {
            if (cur > max) {
                max = cur;
            }
        }

        return max;
    }
}
