import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 
 */

/**
 * @file Solution.java
 * @package
 * @project ZTest
 * @author Administrator
 * @time 2014-4-15
 * 
 * 
 */
public class Solution
{
    public class TreeNode
    {
        int      val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x)
        {
            val = x;
            left = null;
            right = null;
        }
    }

    public List<TreeNode> generateTrees(int n)
    {
        return generateTrees_(1, n);
    }

    private List<TreeNode> generateTrees_(int start, int end)
    {
        if (start > end)
        {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }

        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = start; i <= end; ++i)
        {

            List<TreeNode> lefts = generateTrees_(start, i - 1);
            List<TreeNode> rights = generateTrees_(i + 1, end);

            for (TreeNode left : lefts)
            {
                for (TreeNode right : rights)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }

    public int trap(int[] A)
    {
        int[] leftH = new int[A.length];
        leftH[0] = 0;
        int maxLeftH = A[0];
        for (int i = 1; i < A.length; ++i)
        {
            leftH[i] = maxLeftH;
            if (A[i] > maxLeftH)
            {
                maxLeftH = A[i];
            }
        }

        int[] rightH = new int[A.length];
        rightH[0] = 0;
        int maxRightH = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; --i)
        {
            rightH[i] = maxRightH;
            if (A[i] > maxRightH)
            {
                maxRightH = A[i];
            }
        }

        int sum = 0;
        for (int i = 0; i < A.length; ++i)
        {
            int add = Math.min(leftH[i], rightH[i]) - A[i];
            if (add > 0)
            {
                sum += add;
            }
        }

        return sum;
    }

    static class largestRectangleAreaElem
    {
        int index;

        int height;

        public largestRectangleAreaElem(int index, int height)
        {
            this.index = index;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] height)
    {
        if (null == height || height.length == 0) { return 0; }

        int maxArea = 0;
        Deque<largestRectangleAreaElem> q = new LinkedList<largestRectangleAreaElem>();

        for (int idx = 0; idx < height.length; idx++)
        {
            if (q.isEmpty() || q.getLast().height <= height[idx])
            {
                q.addLast(new largestRectangleAreaElem(idx, height[idx]));
            }
            else
            {
                largestRectangleAreaElem lastPop = null;
                while (!q.isEmpty() && q.getLast().height > height[idx])
                {
                    int w = idx - q.getLast().index;
                    int h = q.getLast().height;
                    int area = w * h;
                    maxArea = Math.max(area, maxArea);
                    lastPop = q.pollLast();
                }

                if (null != lastPop)
                {
                    lastPop.height = height[idx];
                    q.addLast(lastPop);
                }

                q.addLast(new largestRectangleAreaElem(idx, height[idx]));
            }
        }

        while (!q.isEmpty())
        {
            int w = q.getLast().index - q.getFirst().index + 1;
            int h = q.getFirst().height;
            int area = w * h;
            maxArea = Math.max(area, maxArea);
            q.pollFirst();
        }

        return maxArea;
    }

    public String longestPalindrome(String s)
    {
        if (null == s) { return null; }

        int maxLen = 0;
        int maxI = 0;
        int maxJ = 0;
        boolean isOdd = false;
        for (int i = 0; i < s.length(); ++i)
        {
            int oddLen = longestPalindromeInner(s, i, i);
            int evenLen = 0;
            int curI = i;
            int curJ = 0;
            int curLen = 0;

            if (i < s.length() - 1)
            {
                evenLen = longestPalindromeInner(s, i, i + 1);
            }

            if (oddLen >= evenLen)
            {
                curLen = oddLen;
                curJ = i;
                isOdd = true;
            }
            else
            {
                curLen = evenLen;
                curJ = i + 1;
            }

            if (curLen > maxLen)
            {
                maxLen = curLen;
                maxI = curI;
                maxJ = curJ;
                isOdd = oddLen >= evenLen;
            }
        }

        return isOdd ? s.substring(maxI - (maxLen - 1) / 2, maxJ + (maxLen - 1) / 2 + 1) : s.substring(maxI - (maxLen - 2) / 2, maxJ + (maxLen - 2) / 2 + 1);

    }

    private int longestPalindromeInner(String s, int i, int j)
    {
        int len = j - i - 1;
        while (i >= 0 && j < s.length())
        {
            if (s.charAt(i) == s.charAt(j))
            {
                --i;
                ++j;
                len += 2;
            }
            else
            {
                break;
            }
        }

        return len;
    }

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
    
    
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int s = 1 << n;
        for (int i = 0; i < s; ++i) {
            int gray = 0;
            for (int j = 0; j < 32; ++j) {
                int mask = 1 << j;
                int nextMask = mask << 1;
                int b1 = (i & mask) == 0 ? 0 : 1;
                int b2 = (i & nextMask) == 0 ? 0 : 1;
                int gi = b1 ^ b2;
                gray |= gi << j;
            }
            
            result.add(gray);
        }
        
        return result;
    }

    public static void main(String[] args) throws IOException
    {
        System.out.println(new Solution().grayCode(2));
    }

    private static void printTreesLevel(Collection<TreeNode> trees)
    {
        for (TreeNode tree : trees)
        {
            printTreeLevel(tree);
        }
    }

    private static void printTreeLevel(TreeNode root)
    {
        if (null == root) { return; }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);

        while (!queue.isEmpty())
        {
            TreeNode cur = queue.pollFirst();

            if (null == cur)
            {
                System.out.print('#');
            }
            else
            {
                System.out.print(cur.val);
            }

            if (null != cur)
            {
                if (cur.left != null || cur.right != null)
                {
                    queue.addLast(cur.left);
                    queue.add(cur.right);
                }
            }
        }
        System.out.print('\n');
    }

}
