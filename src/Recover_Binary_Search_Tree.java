import util.TreeNode;

/**
 * Created by Administrator on 2014/8/11 0011.
 */
public class Recover_Binary_Search_Tree {
    public void recoverTree(TreeNode root)
    {
        TreeNodeWrapper wrapper = new TreeNodeWrapper();
        inorder(root, wrapper);

        if (wrapper.miss1 != null && wrapper.miss2 != null) {
            int tmp = wrapper.miss1.val;
            wrapper.miss1.val = wrapper.miss2.val;
            wrapper.miss2.val = tmp;
        }
    }

    private void inorder(TreeNode root, TreeNodeWrapper pre) {
        if (null == root) {
            return;
        }

        inorder(root.left, pre);
        access(root, pre);
        inorder(root.right, pre);
    }

    private void access(TreeNode root, TreeNodeWrapper pre) {
        if (null != pre.tree) {
            if (pre.tree.val > root.val) {
                if (null == pre.miss1) {
                    pre.miss1 = pre.tree;
                    pre.miss2 = root;
                } else {
                    // should be root
                    pre.miss2 = root;
                }
            }
        }

        pre.tree = root;
    }

    static class TreeNodeWrapper {
        TreeNode tree;
        TreeNode miss1;
        TreeNode miss2;
    }


    public void recoverTree2(TreeNode root) {
        Helper h = new Helper();
        traversal_(root, h);
        int temp = h.first.val;
        h.first.val = h.second.val;
        h.second.val = temp;
    }

    static class Helper {
        TreeNode prev;
        TreeNode first;
        TreeNode second;
    }

    private void traversal_(TreeNode root, Helper h) {
        if (null == root) {
            return;
        }

        traversal_(root.left, h);
        if (h.prev != null) {
            if (h.prev.val > root.val) {
                if (h.first == null) {
                    h.first = h.prev;
                    h.second = root;
                } else {
                    h.second = root;
                }
            }
        }
        h.prev = root;
        traversal_(root.right, h);
    }
}
