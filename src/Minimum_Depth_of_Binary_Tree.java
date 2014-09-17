import util.TreeNode;

/**
 * Created by www.imgaara.com on 2014/9/17 0017.
 */
public class Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        Wrapper w = new Wrapper();
        w.h = 0;

        return minDepth_(root, w);
    }

    static class Wrapper {
        int h;
    }

    private int minDepth_(TreeNode root, Wrapper w) {
        if (null == root) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int minLeft = root.left == null ? Integer.MAX_VALUE : minDepth_(root.left, w);
            int minRight = root.right == null ? Integer.MAX_VALUE : minDepth_(root.right, w);
            return Math.min(minLeft, minRight) + 1;
        }
    }
}
