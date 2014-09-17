import util.TreeNode;

/**
 * Created by Administrator on 2014/8/13 0013.
 */
public class Sum_Root_to_Leaf_Numbers {
    static class Wrapper {
        int val;
    }

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Wrapper w = new Wrapper();
        w.val = 0;

        sumNumbers_(root, w, 0);
        return w.val;
    }

    private void sumNumbers_(TreeNode root, Wrapper w, int last) {
        if (null == root.left && null == root.right) {
            w.val += last*10 + root.val;
        }

        if (null != root.left) {
            sumNumbers_(root.left, w, last*10 + root.val);
        }

        if (null != root.right) {
            sumNumbers_(root.right, w, last*10 + root.val);
        }
    }
}
