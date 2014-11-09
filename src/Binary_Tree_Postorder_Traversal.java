import util.TreeNode;

import java.util.List;

/**
 * Created by Administrator on 2014/11/9 0009.
 */
public class Binary_Tree_Postorder_Traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();

        TreeNode cur = root;
        TreeNode prev = root;

        TreeNode dummy = new TreeNode(-1);
        dummy.left = cur;
        cur = dummy;

        List<Integer> temp = new ArrayList<>();

        while (null != cur) {
            if (null == cur.left) {
                // 后序，不先输出
                prev = cur; // 到后驱,后驱可能是线索，也有可能是右子树
                cur = cur.right;
            } else {
                TreeNode node = cur.left;
                while (null != node.right && node.right != cur) {
                    node = node.right;
                }

                if (node.right == null) {
                    node.right = cur;   // 这里记录线索就行
                    //prev = cur;
                    cur = cur.left;
                } else {
                    access(temp, cur.left, prev, r); // 逆序从子节点(prev)到left
                    prev = cur;       // 如果cur.right 是线索，那么prev是必须记录的, 不然上句话输出会失败, cur.left, prev不在一条线上
                    node.right = null;
                    cur = cur.right;  // 到后驱,后驱可能是线索，也有可能是右子树
                }
            }
        }

        return r;
    }

    private void access(List<Integer> temp, TreeNode first, TreeNode last, List<Integer> r) {
        temp.clear();
        do {
            temp.add(first.val);
            if (first == last) {
                break;
            }
            first = first.right;
        } while (true);

        for (int i = temp.size() - 1; i >= 0; --i) {
            r.add(temp.get(i));
        }
    }
}
