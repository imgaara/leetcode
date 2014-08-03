import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2014/8/3 0003.
 */
public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> r = new LinkedList<List<Integer>>();
        if (null == root) {
            return r;
        }

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.add(root);

        while (!q1.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            while (!q1.isEmpty()) {
                TreeNode cur = q1.poll();
                level.add(cur.val);
                if (null != cur.left) {
                    q2.add(cur.left);
                }

                if (null != cur.right) {
                    q2.add(cur.right);
                }
            }

            r.addLast(level);
            Queue<TreeNode> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        return r;
    }
}
