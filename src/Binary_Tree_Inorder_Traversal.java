import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/9 0009.
 */
public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();

        TreeNode cur = root;
        TreeNode prev = root;

        while (null != cur) {
            if (null == cur.left) {
                r.add(cur.val);  // 没有左边，中序可以输出
                prev = cur; // 到后驱,后驱可能是线索，也有可能是右子树
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while (null != node.right && node.right != cur) {
                    node = node.right;
                }

                if (node.right == null) {
                    node.right = cur;   // 这里记录线索就行
                    cur = cur.left;
                } else {
                    r.add(cur.val);     // 左侧都已经搞定，可以输
                    prev = cur;
                    node.right = null;
                    cur = cur.right;
                }
            }
        }

        return r;
    }
}
