import util.TreeNode;

/**
 * Created by Administrator on 2014/8/11 0011.
 */
public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        flatten_(root);
    }

    public TreeNode flatten_(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode tailLeft = flatten_(root.left);
        TreeNode tailRight = flatten_(root.right);

        if (tailLeft == null && tailRight == null) {
            return root;
        } else if (tailLeft != null && tailRight == null){
            root.right = root.left;
            root.left = null;
            return tailLeft;
        } else if (tailLeft == null && tailRight != null) {
            return tailRight;
        } else {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            tailLeft.right = temp;
            return tailRight;
        }
    }

    public TreeNode flatten_2(TreeNode root, TreeNode calculatedTail){
        if (null == root) {
            return calculatedTail;
        }

        root.right = flatten_2(root.left, flatten_2(root.right, calculatedTail));
        root.left = null;
        return root;
    }

}
