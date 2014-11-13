import util.TreeNode;
import util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/9 0009.
 */
public class Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>();

        TreeNode cur = root;
        TreeNode prev = null;
        while (null != cur) {
            if (null == cur.left) {
                r.add(cur.val);
                prev = cur;
                cur = cur.right;  // 到后驱,后驱可能是线索，也有可能是右子树
            } else {
                TreeNode node = cur.left;

                // 找到左子树的最右，用来记录线索
                while (node.right != null && node.right != cur) {
                    node = node.right;
                }

                if (node.right == null) {
                    // 左子树找到最右，可以访问了，访问完了建立线索
                    // 等待下次回溯到此
                    r.add(cur.val);
                    prev = cur;
                    node.right = cur;
                    cur = cur.left;
                } else {
                    // 已经是访问过的线索，表明cur已经是访问过的节点，并且左子树都已经遍历完成
                    // 这里就应该继续到右子树
                    node.right = null;
                    cur = cur.right;
                }
            }
        }

        return r;
    }


    public static void main(String[] args) {
        TreeNode root = Utils.generateTree("1", "2", "3", "4", "5", "6", "7");
        System.out.println(new Binary_Tree_Preorder_Traversal().preorderTraversal(root));
    }
}
